package com.siddharthsinghbaghel.healthyways

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {

    private var restTimer: CountDownTimer? = null
    private var exerciseTimer: CountDownTimer? = null
    private var restProgress = 0
    private var exerciseProgress = 0

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        setSupportActionBar(toolbar_exercise_activity)

        val actionBar = supportActionBar
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        setUpRestView()

        exerciseList = Constants.defaultExerciseList()

    }

    override fun onDestroy() {
        if(restTimer != null)
        {
            restTimer!!.cancel()
            restProgress = 0
        }

        super.onDestroy()
    }

  private fun setRestProgressBar(){
      progressBar.progress = restProgress
      restTimer = object: CountDownTimer(10000,1000){
          override fun onTick(millisUntilFinished: Long) {
              restProgress++
              progressBar.progress = 10 - restProgress
              tvTimer.text = (10 - restProgress).toString()
          }

          override fun onFinish() {
              Toast.makeText(this@ExerciseActivity, "Let's start exercising", Toast.LENGTH_SHORT).show()

              llRestView.visibility = View.GONE
              setUpExerciseView()

          }
      }.start()
  }

    private fun setUpRestView(){
        if(restTimer != null)
        {
            restTimer!!.cancel()
            restProgress = 0
        }
      setRestProgressBar()
    }

    private fun setExerciseProgressBar(){
        exerciseProgressBar.progress = exerciseProgress
        exerciseTimer = object: CountDownTimer(30000,1000){

            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                exerciseProgressBar.progress = 30 - exerciseProgress
                println(exerciseProgressBar.progress)
                tvExerciseTimer.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Exercising end", Toast.LENGTH_SHORT).show()

            }
        }.start()
    }

    private fun setUpExerciseView(){
        if(exerciseTimer != null)
        {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }
        llExerciseView.visibility = View.VISIBLE
        setExerciseProgressBar()



    }
}