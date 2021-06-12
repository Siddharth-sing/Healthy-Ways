package com.siddharthsinghbaghel.healthyways.tools.oneRM

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.siddharthsinghbaghel.healthyways.R
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_one_r_m_calculater.*
import kotlinx.android.synthetic.main.activity_one_r_m_calculater.toolbar_oneRM_activity
import java.math.BigDecimal
import java.math.RoundingMode

class OneRMCalculatorActivity : AppCompatActivity() {

    val METRIC_UNITS_VIEW = "METRIC_UNITS_VIEW"
    val US_UNITS_VIEW = "US_UNITS_VIEW"
    var currentVisibleView: String = "METRIC_UNITS_VIEW"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_r_m_calculater)

        setSupportActionBar(toolbar_oneRM_activity)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "Calculator 1RM"
        toolbar_oneRM_activity.setNavigationOnClickListener {

            onBackPressed()
        }




         /* For setting up the image according to the exercise selected */

             if(currentVisibleView == METRIC_UNITS_VIEW){
                 setSpinner(spExerciseMetric)

             }else if(currentVisibleView == US_UNITS_VIEW){
                 setSpinner(spExerciseUS)
             }
         /* For setting up the image according to the exercise selected */

        btnCalculateUnitsRM.setOnClickListener {

            if(validateUnits()){

                when (currentVisibleView) {
                    METRIC_UNITS_VIEW -> {

                        val repValue = etMetricUnitRep.text.toString().toFloat()
                        val weightValue = etMetricUnitWeightRM.text.toString().toFloat()

                        calculateOneRM(repValue,weightValue)
                    }
                    US_UNITS_VIEW -> {

                        val repValue = etUsUnitRep.text.toString().toFloat()
                        val weightValue = etUsUnitWeightRM.text.toString().toFloat()

                        calculateOneRM(repValue,weightValue)
                    }
                }
            }else{
                Toast.makeText(
                        this,
                        "Please Enter valid values !!",
                        Toast.LENGTH_SHORT
                ).show()
            }

        }
        makeVisibleMetricUnitsView()

        /* Radio btn check listener*/

        rgUnitsRM.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.rdBtnMetricRM -> {
                    makeVisibleMetricUnitsView()
                }
                R.id.rdBtnUSUnitsRM -> {
                    makeVisibleUSUnitsView()
                }
            }
        }
        /* Radio btn check listener*/
}

    private fun calculateOneRM(repValue: Float, weightValue: Float) {

        var resultOneRm = weightValue * 36/(37 - repValue)

        if(currentVisibleView == METRIC_UNITS_VIEW)
        {
            resultOneRm = weightValue * 36/(37 - repValue)

        }else if(currentVisibleView == US_UNITS_VIEW){

            resultOneRm = weightValue * 36/(37 - repValue)
        }
        llDisplayRMResult.visibility = View.VISIBLE

        val oneRMValue = BigDecimal(resultOneRm.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        tvRMValue.text = oneRMValue

    }


    /* VISIBILITY OF UNITS VIEWS */
    private fun makeVisibleMetricUnitsView(){

        currentVisibleView = METRIC_UNITS_VIEW
        tilMetricUnitWeightRM.visibility = View.VISIBLE
        tilMetricUnitRep.visibility = View.VISIBLE
        spExerciseMetric.visibility = View.VISIBLE

        tilUsUnitWeightRM.visibility = View.GONE
        tilUsUnitRep.visibility = View.GONE
        spExerciseUS.visibility = View.GONE

        etMetricUnitWeightRM.text!!.clear()
        etMetricUnitRep.text!!.clear()


        llDisplayRMResult.visibility = View.GONE
    }
    private fun makeVisibleUSUnitsView(){

        currentVisibleView = US_UNITS_VIEW
        tilUsUnitWeightRM.visibility = View.VISIBLE
        tilUsUnitRep.visibility = View.VISIBLE
        spExerciseUS.visibility = View.VISIBLE

        tilMetricUnitWeightRM.visibility = View.GONE
        tilMetricUnitRep.visibility = View.GONE
        spExerciseMetric.visibility = View.GONE

        etUsUnitWeightRM.text!!.clear()
        etUsUnitRep.text!!.clear()



        llDisplayRMResult.visibility = View.GONE
    }

    /* VISIBILITY OF UNITS VIEWS */

    private fun validateUnits(): Boolean{

        var isValid = true

        when (currentVisibleView) {

            METRIC_UNITS_VIEW -> {

                when {
                    etMetricUnitWeightRM.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etMetricUnitRep.text.toString().isEmpty() -> {
                        isValid = false
                    }


                }
            }

            US_UNITS_VIEW -> {

                when {
                    etUsUnitWeightRM.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etUsUnitRep.text.toString().isEmpty() -> {
                        isValid = false
                    }
                }
            }
        }

        return isValid
    }

    private fun setSpinner(spinnerToSet : Spinner){

        spinnerToSet.onItemSelectedListener = object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                Toast.makeText(this@OneRMCalculatorActivity,
                        "selected item is ${parent?.getItemAtPosition(position).toString()}",
                        Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                Toast.makeText(this@OneRMCalculatorActivity,
                        "Clicked item is ${parent?.getItemAtPosition(position).toString()}",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }
}