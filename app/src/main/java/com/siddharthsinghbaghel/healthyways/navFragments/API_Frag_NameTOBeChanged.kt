package com.siddharthsinghbaghel.healthyways.navFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.siddharthsinghbaghel.healthyways.R
import com.siddharthsinghbaghel.healthyways.exercise.ExerciseActivity
import kotlinx.android.synthetic.main.fragment_exercise.view.*


class API_Frag_NameTOBeChanged : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myApiFragment = inflater.inflate(R.layout.api_name_to_be_changed, container, false)


        return myApiFragment
    }
}