package com.example.luheiko

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.luheiko.databinding.FragmentDoorAccesBinding
import com.example.luheiko.databinding.FragmentTemperatureBinding
import org.json.JSONArray
import org.json.JSONObject

class DoorAccesFragment : Fragment() {

    lateinit var binding: FragmentDoorAccesBinding
    lateinit var button: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDoorAccesBinding.inflate(inflater,container,false);
        var view : View = binding.root;
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button = binding.openDoor

        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var URL = "http://classicharburg.ddns.net:8090/door"
                var requestQueue: RequestQueue = Volley.newRequestQueue(context)

                var jsonObjectRequest: JsonArrayRequest = JsonArrayRequest(Request.Method.GET, URL, null, object: Response.Listener<JSONArray>{
                    override fun onResponse(response: JSONArray?) {


                        Log.e("Login" ,"geklappt")
                    }

                },object: Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {
                        Log.e("Login","Error")
                    }
                })

                requestQueue.add(jsonObjectRequest)
            }

        })
    }

}