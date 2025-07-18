package com.example.getallsensors
import android.hardware.Sensor

// Sensor.getType()の返り値の数値から対応するセンサータイプを返す関数
fun sensorTypeToString(type: Int): String {
    return when (type) {
        Sensor.TYPE_ACCELEROMETER -> "Accelerometer"
        Sensor.TYPE_MAGNETIC_FIELD -> "Magnetic Field"
        Sensor.TYPE_ORIENTATION -> "Orientation (Deprecated)"
        Sensor.TYPE_GYROSCOPE -> "Gyroscope"
        Sensor.TYPE_LIGHT -> "Light"
        Sensor.TYPE_PRESSURE -> "Pressure"
        Sensor.TYPE_TEMPERATURE -> "Temperature (Deprecated)"
        Sensor.TYPE_PROXIMITY -> "Proximity"
        Sensor.TYPE_GRAVITY -> "Gravity"
        Sensor.TYPE_LINEAR_ACCELERATION -> "Linear Acceleration"
        Sensor.TYPE_ROTATION_VECTOR -> "Rotation Vector"
        Sensor.TYPE_RELATIVE_HUMIDITY -> "Relative Humidity"
        Sensor.TYPE_AMBIENT_TEMPERATURE -> "Ambient Temperature"
        Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED -> "Magnetic Field (Uncalibrated)"
        Sensor.TYPE_GAME_ROTATION_VECTOR -> "Game Rotation Vector"
        Sensor.TYPE_GYROSCOPE_UNCALIBRATED -> "Gyroscope (Uncalibrated)"
        Sensor.TYPE_SIGNIFICANT_MOTION -> "Significant Motion"
        Sensor.TYPE_STEP_DETECTOR -> "Step Detector"
        Sensor.TYPE_STEP_COUNTER -> "Step Counter"
        Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR -> "Geomagnetic Rotation Vector"
        Sensor.TYPE_HEART_RATE -> "Heart Rate"
        Sensor.TYPE_POSE_6DOF -> "6DOF Pose"
        Sensor.TYPE_STATIONARY_DETECT -> "Stationary Detect"
        Sensor.TYPE_MOTION_DETECT -> "Motion Detect"
        Sensor.TYPE_HEART_BEAT -> "Heart Beat"
        Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT -> "Low Latency Off-Body Detect"
        Sensor.TYPE_ACCELEROMETER_UNCALIBRATED -> "Accelerometer (Uncalibrated)"
        else -> "Unknown Sensor Type ($type)"
    }
}

// Sensor.getType() の数値から定数名を文字列で返す関数
fun sensorTypeToConstName(type: Int): String {
    return when (type) {
        Sensor.TYPE_ACCELEROMETER -> "TYPE_ACCELEROMETER"
        Sensor.TYPE_MAGNETIC_FIELD -> "TYPE_MAGNETIC_FIELD"
        Sensor.TYPE_ORIENTATION -> "TYPE_ORIENTATION"
        Sensor.TYPE_GYROSCOPE -> "TYPE_GYROSCOPE"
        Sensor.TYPE_LIGHT -> "TYPE_LIGHT"
        Sensor.TYPE_PRESSURE -> "TYPE_PRESSURE"
        Sensor.TYPE_TEMPERATURE -> "TYPE_TEMPERATURE"
        Sensor.TYPE_PROXIMITY -> "TYPE_PROXIMITY"
        Sensor.TYPE_GRAVITY -> "TYPE_GRAVITY"
        Sensor.TYPE_LINEAR_ACCELERATION -> "TYPE_LINEAR_ACCELERATION"
        Sensor.TYPE_ROTATION_VECTOR -> "TYPE_ROTATION_VECTOR"
        Sensor.TYPE_RELATIVE_HUMIDITY -> "TYPE_RELATIVE_HUMIDITY"
        Sensor.TYPE_AMBIENT_TEMPERATURE -> "TYPE_AMBIENT_TEMPERATURE"
        Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED -> "TYPE_MAGNETIC_FIELD_UNCALIBRATED"
        Sensor.TYPE_GAME_ROTATION_VECTOR -> "TYPE_GAME_ROTATION_VECTOR"
        Sensor.TYPE_GYROSCOPE_UNCALIBRATED -> "TYPE_GYROSCOPE_UNCALIBRATED"
        Sensor.TYPE_SIGNIFICANT_MOTION -> "TYPE_SIGNIFICANT_MOTION"
        Sensor.TYPE_STEP_DETECTOR -> "TYPE_STEP_DETECTOR"
        Sensor.TYPE_STEP_COUNTER -> "TYPE_STEP_COUNTER"
        Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR -> "TYPE_GEOMAGNETIC_ROTATION_VECTOR"
        Sensor.TYPE_HEART_RATE -> "TYPE_HEART_RATE"
        Sensor.TYPE_POSE_6DOF -> "TYPE_POSE_6DOF"
        Sensor.TYPE_STATIONARY_DETECT -> "TYPE_STATIONARY_DETECT"
        Sensor.TYPE_MOTION_DETECT -> "TYPE_MOTION_DETECT"
        Sensor.TYPE_HEART_BEAT -> "TYPE_HEART_BEAT"
        Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT -> "TYPE_LOW_LATENCY_OFFBODY_DETECT"
        Sensor.TYPE_ACCELEROMETER_UNCALIBRATED -> "TYPE_ACCELEROMETER_UNCALIBRATED"
        else -> "UNKNOWN_TYPE_$type"
    }
}
