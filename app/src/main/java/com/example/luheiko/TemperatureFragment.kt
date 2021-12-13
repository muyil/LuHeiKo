package com.example.luheiko

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.luheiko.databinding.FragmentTemperatureBinding
import org.json.JSONArray
import org.json.JSONObject


class TemperatureFragment : Fragment() {

    lateinit var binding: FragmentTemperatureBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: TemperatureAdapter

    var temperaturesList = mutableListOf<Temperature>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTemperatureBinding.inflate(inflater,container,false);
        var view : View = binding.root;
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.temperatureList

        var URL = "http://classicharburg.ddns.net:8090/temperature"
        var requestQueue: RequestQueue = Volley.newRequestQueue(context)

        var jsonObjectRequest: JsonArrayRequest = JsonArrayRequest(Request.Method.GET, URL, null, object: Response.Listener<JSONArray>{
            override fun onResponse(response: JSONArray?) {
                for(i in 0 until response!!.length()) {
                    var temperatureObject : JSONObject = response.getJSONObject(i)

                    var temperature: Temperature = Temperature(temperatureObject.getInt("Id".toString()),temperatureObject.getInt("Temperature".toString())
                        ,temperatureObject.getString("MessuredDay".toString()),temperatureObject.getString("Description".toString()))
                    temperaturesList.add(temperature)
                }
                recyclerView.layoutManager = LinearLayoutManager(context!!.applicationContext)
                adapter = TemperatureAdapter(context!!.applicationContext,temperaturesList)
                recyclerView.adapter = adapter

                Log.e("Login" ,"geklappt")
            }

        },object: Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    Log.e("Login","Error")
                }
        })

        requestQueue.add(jsonObjectRequest)
    }

}