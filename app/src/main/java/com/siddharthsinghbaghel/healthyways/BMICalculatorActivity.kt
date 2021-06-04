package com.siddharthsinghbaghel.healthyways

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*

class BMICalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        setSupportActionBar(toolbar_bmi_activity)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "Calculator BMI"
        toolbar_bmi_activity.setNavigationOnClickListener {

            onBackPressed()
        }

    }
}