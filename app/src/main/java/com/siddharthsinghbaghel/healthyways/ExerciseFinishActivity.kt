package com.siddharthsinghbaghel.healthyways

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exercise.*
import kotlinx.android.synthetic.main.activity_exercise.toolbar_exercise_activity
import kotlinx.android.synthetic.main.activity_exercise_finish.*

class ExerciseFinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_finish)

        setSupportActionBar(toolbar_finish_activity)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_finish_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        btnFinishExercise.setOnClickListener{
            finish()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}