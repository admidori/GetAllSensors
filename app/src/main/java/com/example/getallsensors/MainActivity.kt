package com.example.getallsensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorList: ArrayList<SensorObject>

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
            sensorList.add(SensorObject().apply {
                name = sensor.name
                power = sensor.power
                mindelay = sensor.minDelay
            })
        }

        val listView = findViewById<ListView>(R.id.list_view)
        val customAdapter = ListAdapter(this, sensorList)
        listView.adapter = customAdapter

    }
}
