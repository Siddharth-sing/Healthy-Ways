package com.siddharthsinghbaghel.healthyways

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.siddharthsinghbaghel.healthyways.NavFragments.ExerciseFragment
import com.siddharthsinghbaghel.healthyways.NavFragments.HistoryFragment
import com.siddharthsinghbaghel.healthyways.NavFragments.ToolsFragment
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_history.toolbar_history_activity
import kotlinx.android.synthetic.main.activity_main_1.*

class MainActivity1 : AppCompatActivity() {

    private val toolsFragment = ToolsFragment()
    private val historyFragment = HistoryFragment()
    private val exerciseFragment = ExerciseFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_1)

        setSupportActionBar(toolbar_activity_main_1)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "History"
        toolbar_history_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        replaceFragments(exerciseFragment)

        bottomNav.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.tools -> replaceFragments(toolsFragment)
                R.id.sevenMinExercises -> replaceFragments(exerciseFragment)
                R.id.history -> replaceFragments(historyFragment)
            }
            true
        }
    }

    private fun replaceFragments(fragment: Fragment){

        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}