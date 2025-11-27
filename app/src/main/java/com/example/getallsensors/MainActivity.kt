package com.example.getallsensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorList: ArrayList<SensorObject>
    private lateinit var listViewAdapter: ListAdapter
    private val sensorMap = HashMap<Sensor, SensorObject>()

    companion object{
        lateinit var instance: MainActivity
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        instance = this
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        Log.d("MyApp", "$deviceSensors")

        sensorList = arrayListOf()
        for(sensor: Sensor in deviceSensors){
            val obj = SensorObject().apply {
                name = sensor.name
                power = sensor.power
                type = sensorTypeToConstName(sensor.type)
                mindelay = sensor.minDelay
            }
            sensorList.add(obj)
            sensorMap[sensor] = obj
        }

        val listView = findViewById<ListView>(R.id.list_view)
        listViewAdapter = ListAdapter(this, sensorList)
        listView.adapter = listViewAdapter
    }

    override fun onResume() {
        super.onResume()
        for (sensor in sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        val obj = sensorMap[event.sensor] ?: return
        obj.values = event.values.clone()
        listViewAdapter.notifyDataSetChanged()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) { /* 未使用 */ }
}
