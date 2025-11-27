package com.example.getallsensors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter (private val context: Context, private val sensorList: ArrayList<SensorObject>) : BaseAdapter() {

    private val resources = context.resources

    private data class ViewHolder(
        val name: TextView,
        val power: TextView,
        val type: TextView,
        val mindelay: TextView,
        val values: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
            holder = ViewHolder(
                name = view.findViewById(R.id.name),
                power = view.findViewById(R.id.power),
                type = view.findViewById(R.id.type),
                mindelay = view.findViewById(R.id.mindelay),
                values = view.findViewById(R.id.values)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val sensor = sensorList[position]

        holder.name.text = resources.getString(R.string.sensor_name, sensor.name)
        holder.power.text = resources.getString(R.string.sensor_power, sensor.power)
        holder.type.text = resources.getString(R.string.sensor_type, sensor.type)
        holder.mindelay.text = resources.getString(R.string.sensor_mindelay, sensor.mindelay)
        val formattedValues = if (sensor.values.isNotEmpty()) sensor.values.joinToString(", ") { String.format("%.2f", it) } else "-"
        holder.values.text = resources.getString(R.string.sensor_values, formattedValues)

        return view
    }

    override fun getItem(position: Int): Any = sensorList[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = sensorList.size
}