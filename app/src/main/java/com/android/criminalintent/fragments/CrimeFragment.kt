package com.android.criminalintent.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.android.criminalintent.R
import com.android.criminalintent.model.Crime

class CrimeFragment : Fragment(){

    private lateinit var crime : Crime

    private lateinit var titleField : EditText

    private lateinit var dateButton: Button

    private lateinit var solvedCheckBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_crime,container,false)

        titleField = view.findViewById(R.id.crime_title) as EditText

        dateButton = view.findViewById(R.id.crime_date) as Button

        dateButton.apply {

            text = crime.date.toString()

            // disabling the button to  ensure it does not respond to users click...
            isEnabled = false

        }

        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        return view
    }


    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher{
            override fun afterTextChanged(sequence: Editable?) {

            }

            override fun beforeTextChanged(sequence : CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(sequence : CharSequence?, start: Int, count: Int, after: Int) {
                crime.title = sequence.toString()
            }

        }
        titleField.addTextChangedListener(titleWatcher)

        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
            }
        }

    }

}