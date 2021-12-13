package com.example.luheiko

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HumidityAdapter(ctx: Context, humidityList: List<Humidity>): RecyclerView.Adapter<HumidityAdapter.ViewHolder>() {
    var layoutInflater: LayoutInflater
    var humidityList: List<Humidity>

    init {
        this.layoutInflater = LayoutInflater.from(ctx)
        this.humidityList = humidityList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = layoutInflater.inflate(R.layout.data_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = humidityList[position].id.toString()
        holder.temperature.text = humidityList[position].humidity.toString()
        holder.date.text = humidityList[position].messuredDay
        holder.description.text = humidityList[position].description
    }

    override fun getItemCount(): Int {
        return humidityList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var id: TextView = itemView.findViewById(R.id.id)
        var temperature: TextView = itemView.findViewById(R.id.einheit)
        var date: TextView = itemView.findViewById(R.id.messureddate)
        var description: TextView = itemView.findViewById(R.id.description)
    }
}