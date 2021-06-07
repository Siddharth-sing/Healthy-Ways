package com.siddharthsinghbaghel.healthyways

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.siddharthsinghbaghel.healthyways.tools.BMI.BMIHistoryViewActivity

import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        setSupportActionBar(toolbar_history_activity)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "History"
        toolbar_history_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        llBMIHistory.setOnClickListener {

            val intent = Intent(this,BMIHistoryViewActivity::class.java)
            startActivity(intent)
        }

    }
}