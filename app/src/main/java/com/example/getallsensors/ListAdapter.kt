package com.example.getallsensors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter (private val context: Context, private val sensorList: ArrayList<SensorObject>) : BaseAdapter() {

    private val contextMain = MainActivity.instance.applicationContext
    private val resources = contextMain.resources

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        val name = view.findViewById<TextView>(R.id.name)
        val power = view.findViewById<TextView>(R.id.power)
        val type = view.findViewById<TextView>(R.id.type)
        val mindelay = view.findViewById<TextView>(R.id.mindelay)

        val sensor = sensorList[position]

        name.text = resources.getString(R.string.sensor_name, sensor.name)
        power.text = resources.getString(R.string.sensor_power, sensor.power)
        type.text = resources.getString(R.string.sensor_type, sensor.type)
        mindelay.text = resources.getString(R.string.sensor_mindelay, sensor.mindelay)

        return view
    }

    override fun getItem(position: Int): Any {
        return sensorList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return sensorList.size
    }
}