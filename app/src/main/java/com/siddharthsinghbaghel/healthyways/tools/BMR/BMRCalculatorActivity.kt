package com.siddharthsinghbaghel.healthyways.tools.BMR

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.siddharthsinghbaghel.healthyways.R
import kotlinx.android.synthetic.main.activity_b_m_r_calculator.*
import kotlinx.android.synthetic.main.activity_body_fat_calculator.*

class BMRCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_r_calculator)

        setSupportActionBar(toolbar_bmr_activity)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "BMR & TDEE"
        toolbar_bmr_activity.setNavigationOnClickListener {

            onBackPressed()
        }

    }
}