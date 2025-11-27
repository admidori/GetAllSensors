package com.example.getallsensors

data class SensorObject(
    var name: String = "",
    var power: Float = 0f,
    var type: String = "",
    var mindelay: Int = 0,
    var values: FloatArray = floatArrayOf()
)