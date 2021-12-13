package com.example.luheiko

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TemperatureAdapter(ctx: Context, temperatureList: List<Temperature>): RecyclerView.Adapter<TemperatureAdapter.ViewHolder>() {
    var layoutInflater: LayoutInflater
    var temperatureList: List<Temperature>

    init {
        this.layoutInflater = LayoutInflater.from(ctx)
        this.temperatureList = temperatureList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = layoutInflater.inflate(R.layout.data_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = temperatureList[position].id.toString()
        holder.temperature.text = temperatureList[position].temperature.toString()
        holder.date.text = temperatureList[position].messuredDay
        holder.description.text = temperatureList[position].description
    }

    override fun getItemCount(): Int {
        return temperatureList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var id: TextView = itemView.findViewById(R.id.id)
        var temperature: TextView = itemView.findViewById(R.id.einheit)
        var date: TextView = itemView.findViewById(R.id.messureddate)
        var description: TextView = itemView.findViewById(R.id.description)
    }
}