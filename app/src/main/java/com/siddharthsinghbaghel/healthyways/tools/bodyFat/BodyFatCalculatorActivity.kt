package com.siddharthsinghbaghel.healthyways.tools.bodyFat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import com.siddharthsinghbaghel.healthyways.R
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_body_fat_calculator.*
import kotlinx.android.synthetic.main.activity_one_r_m_calculater.*
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.log10

class BodyFatCalculatorActivity : AppCompatActivity() {

    val METRIC_UNITS_VIEW = "METRIC_UNITS_VIEW"
    val US_UNITS_VIEW = "US_UNITS_VIEW"
    var currentVisibleView: String = "METRIC_UNITS_VIEW"
    var genderSelected : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_fat_calculator)

        setSupportActionBar(toolbar_bodyFat_activity)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "Body Fat Percentage"
        toolbar_bodyFat_activity.setNavigationOnClickListener {

            onBackPressed()
        }



        btnCalculateBFC.setOnClickListener {

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

            if(validateUnits()){

                when (currentVisibleView) {

                    METRIC_UNITS_VIEW -> {

                        val heightValue = etInchBFCHeight.text.toString().toFloat()
                        val neckValue = etInchBFCNeck.text.toString().toFloat()
                        val waistValue = etInchBFCWaist.text.toString().toFloat()
                        val weightValue = etInchBFCMassValue.text.toString().toFloat()

                        calculateBFC(heightValue,waistValue,neckValue,weightValue,genderSelected,);


                    }
                    US_UNITS_VIEW -> {

                        val heightValue = etCMBFCHeight.text.toString().toFloat()
                        val neckValue = etCMBFCNeck.text.toString().toFloat()
                        val waistValue = etCMBFCWaist.text.toString().toFloat()
                        val weightValue = etCMBFCMassValue.text.toString().toFloat()

                        calculateBFC(heightValue,waistValue,neckValue,weightValue,genderSelected,);


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

        /* Initializing the calculator view */

        makeVisibleMetricView()


        /* Initializing the calculator view */

        /* Radio btn check listener*/

        rgUnitsBFC.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.rdBtnMetricsBFC -> {
                    makeVisibleMetricView()
                }
                R.id.rdBtnUSBFC -> {
                    makeVisibleUSView()
                }
            }
        }
        /* Radio btn check listener*/



    }

    private fun calculateBFC(heightValue: Float, waistValue: Float, neckValue: Float, weightValue: Float,genderSelected: Int) {

        var resultBF : Float = (86.010 * waistValue - neckValue - 70.041 * log10(heightValue) + 36.76).toFloat()
        var massFat : Float =  resultBF * weightValue

        when (currentVisibleView) {
            METRIC_UNITS_VIEW -> {
                when (genderSelected) {
                    0 -> {
                         resultBF = (86.010 * waistValue - neckValue - 70.041 * log10(heightValue) + 36.76).toFloat()
                         massFat = resultBF * weightValue
                    }
                    1 -> {
                        resultBF = (163.205 * log10(waistValue - neckValue) - 97.684 * log10(heightValue) - 78.387).toFloat()
                        massFat = resultBF * weightValue
                    }
                }
            }
            US_UNITS_VIEW->{
                when (genderSelected) {
                0 -> {
                    resultBF = ((495 / ( 1.0324 - 0.19077 * log10(waistValue - neckValue)  + 0.15456 * log10(heightValue))) - 450).toFloat()
                    massFat = resultBF * weightValue

                }
                1 -> {
                    resultBF = ((495 / ( 1.29579 - 0.35004 * log10(waistValue - neckValue)  + 0.22100 * log10(heightValue))) - 450).toFloat()
                    massFat = resultBF * weightValue
                }
            }
          }
        }
        val resultBFValue = BigDecimal(resultBF.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        val resultMassFatValue = BigDecimal(massFat.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        llResultBFC.visibility = View.VISIBLE
        tvFatPercBFCValue.text = resultBFValue
        tvFatMassBFCValue.text = resultMassFatValue

    }


    private fun makeVisibleUSView(){

        currentVisibleView = US_UNITS_VIEW
        tilInchBFCHeight.visibility = View.VISIBLE
        tilInchBFCNeck.visibility = View.VISIBLE
        tilInchBFCWaist.visibility = View.VISIBLE
        tilInchBFCMass.visibility = View.VISIBLE


        tilCMBFCHeight.visibility = View.GONE
        tilCMBFCNeck.visibility = View.GONE
        tilCMBFCWaist.visibility = View.GONE
        tilCMBFCMass.visibility = View.GONE


        etInchBFCHeight.text!!.clear()
        etInchBFCNeck.text!!.clear()
        etInchBFCWaist.text!!.clear()
        etInchBFCMassValue.text!!.clear()


        llResultBFC.visibility = View.GONE
    }
    private fun makeVisibleMetricView(){

        currentVisibleView = METRIC_UNITS_VIEW

        tilInchBFCHeight.visibility = View.GONE
        tilInchBFCNeck.visibility = View.GONE
        tilInchBFCWaist.visibility = View.GONE
        tilInchBFCMass.visibility = View.GONE


        tilCMBFCHeight.visibility = View.VISIBLE
        tilCMBFCNeck.visibility = View.VISIBLE
        tilCMBFCWaist.visibility = View.VISIBLE
        tilCMBFCMass.visibility = View.VISIBLE


        etCMBFCHeight.text!!.clear()
        etCMBFCNeck.text!!.clear()
        etCMBFCWaist.text!!.clear()
        etCMBFCMassValue.text!!.clear()


        llResultBFC.visibility = View.GONE
    }


    private fun validateUnits(): Boolean{

        var isValid = true

        when (currentVisibleView) {

           METRIC_UNITS_VIEW -> {

                when {
                    etInchBFCHeight.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etInchBFCNeck.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etInchBFCWaist.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etInchBFCMassValue.text.toString().isEmpty() -> {
                        isValid = false
                    }


                }
            }

            US_UNITS_VIEW -> {

                when {
                    etCMBFCHeight.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etCMBFCNeck.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etCMBFCWaist.text.toString().isEmpty() -> {
                        isValid = false
                    }
                    etCMBFCMassValue.text.toString().isEmpty() -> {
                        isValid = false
                    }
                }
            }
        }

        return isValid
    }

    private fun setSpinner(spGenderToSet: Spinner?){

        spGenderToSet?.onItemSelectedListener = object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if(currentVisibleView == US_UNITS_VIEW){
                    Toast.makeText(this@BodyFatCalculatorActivity,
                        "US selected item is ${parent?.getItemAtPosition(position).toString()} and position $position",
                        Toast.LENGTH_SHORT).show()
                }else if(currentVisibleView == METRIC_UNITS_VIEW){
                    Toast.makeText(this@BodyFatCalculatorActivity,
                        "Metric selected item is ${parent?.getItemAtPosition(position).toString()} and position $position",
                        Toast.LENGTH_SHORT).show()
                }

                when (position) {
                    0 -> {
                         genderSelected = 0
                        Toast.makeText(this@BodyFatCalculatorActivity,
                            "Male",
                            Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        genderSelected = 1
                        Toast.makeText(this@BodyFatCalculatorActivity,
                            "Female",
                            Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Nothing")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Nothing")
            }
        }
    }
}

