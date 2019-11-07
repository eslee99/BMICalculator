package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageCategory.setImageResource(R.drawable.defaultt)
        btnCalculate.setOnClickListener(){
            calculateBMI()
        }
        btnReset.setOnClickListener(){
            reset()
        }
    }
    private fun calculateBMI() {
        val height=editHeight.text.toString().toFloat()
        val weight=editWeight.text.toString().toFloat()
        val bmi=weight /(height*height)
        if(bmi<18.5) {
            textCategory.setText(getString(R.string.category) + ": " + getString(R.string.underWeight))
            imageCategory.setImageResource(R.drawable.under)
        }
        else if(bmi>=18.5&&bmi<=24.9){
            textCategory.setText(getString(R.string.category)+": "+getString(R.string.normal))
            imageCategory.setImageResource(R.drawable.normal)
        }
        else {
            textCategory.setText(getString(R.string.category) + ": " + getString(R.string.overWeight))
            imageCategory.setImageResource(R.drawable.over)
        }

        textBmi.setText(getString(R.string.bmi)+": "+String.format("%.2f",bmi))

    }
    private fun reset(){
        imageCategory.setImageResource(R.drawable.defaultt)
        editHeight.text.clear()
        editWeight.text.clear()
        textBmi.setText("")
        textCategory.setText("")
    }
}
