package com.robosh.augumentedreality

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    private var mSensorManager: SensorManager? = null
    private var mSensorAccelerometer: Sensor? = null
    private var mSensorMagnetometer: Sensor? = null
    private var mAccelerometerData = FloatArray(3)
    private var mMagnetometerData = FloatArray(3)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mSensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager
        mSensorAccelerometer = mSensorManager?.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER
        )
        mSensorMagnetometer = mSensorManager?.getDefaultSensor(
            Sensor.TYPE_MAGNETIC_FIELD
        )

        WebView.setWebContentsDebuggingEnabled(true);
        webView.settings.javaScriptEnabled = true

        val encodedHtml = Base64.encodeToString(htmlThreeJsCode.toByteArray(), Base64.NO_PADDING)
        webView.loadData(encodedHtml, "text/html", "base64")
    }

    override fun onStart() {
        super.onStart()

        if (mSensorAccelerometer != null) {
            mSensorManager?.registerListener(
                this, mSensorAccelerometer,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
        if (mSensorMagnetometer != null) {
            mSensorManager?.registerListener(
                this, mSensorMagnetometer,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

    override fun onStop() {
        super.onStop()
        mSensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        when (sensorEvent!!.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> mAccelerometerData = sensorEvent.values.clone()
            Sensor.TYPE_MAGNETIC_FIELD -> mMagnetometerData = sensorEvent.values.clone()
            else -> return
        }

        val rotationMatrix = FloatArray(9)
        val rotationOK = SensorManager.getRotationMatrix(
            rotationMatrix,
            null, mAccelerometerData, mMagnetometerData
        )
        val orientationValues = FloatArray(3)
        if (rotationOK) {
            SensorManager.getOrientation(rotationMatrix, orientationValues)
        }
        val azimuth = orientationValues[0]
        val pitch = orientationValues[1]
        val roll = orientationValues[2]
        webView.loadUrl("javascript:setAxisA($azimuth, $pitch, $roll)")
    }
}