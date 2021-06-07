package com.siddharthsinghbaghel.healthyways

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.siddharthsinghbaghel.healthyways.Exercise.ExerciseActivity
import com.siddharthsinghbaghel.healthyways.tools.BMI.BMICalculatorActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llStart.setOnClickListener{
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        llBMI.setOnClickListener{
            val intent = Intent(this, BMICalculatorActivity::class.java)
            startActivity(intent)
        }

        llHistory.setOnClickListener{
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}