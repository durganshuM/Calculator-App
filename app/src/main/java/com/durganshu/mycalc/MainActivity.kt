package com.durganshu.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.durganshu.mycalc.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var flag = 0
    private var result: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.BTN0.setOnClickListener {
            typeCalcTV(binding.BTN0.text.toString())
        }

        binding.BTN1.setOnClickListener {
            typeCalcTV(binding.BTN1.text.toString())
        }

        binding.BTN2.setOnClickListener {
            typeCalcTV(binding.BTN2.text.toString())
        }

        binding.BTN3.setOnClickListener {
            typeCalcTV(binding.BTN3.text.toString())
        }

        binding.BTN4.setOnClickListener {
            typeCalcTV(binding.BTN4.text.toString())
        }

        binding.BTN5.setOnClickListener {
            typeCalcTV(binding.BTN5.text.toString())
        }

        binding.BTN6.setOnClickListener {
            typeCalcTV(binding.BTN6.text.toString())
        }

        binding.BTN7.setOnClickListener {
            typeCalcTV(binding.BTN7.text.toString())
        }

        binding.BTN8.setOnClickListener {
            typeCalcTV(binding.BTN8.text.toString())
        }

        binding.BTN9.setOnClickListener {
            typeCalcTV(binding.BTN9.text.toString())
        }

        binding.BTNDot.setOnClickListener {
            if(binding.calcTV1.text == ""){
                typeCalcTV("0.")
            }

            else{
                typeCalcTV(binding.BTNDot.text.toString())
            }
        }

        binding.BTNAdd.setOnClickListener {
            addFun()
        }


        binding.BTNSub.setOnClickListener {
            subFun()
        }

        binding.BTNMult.setOnClickListener {
            multFun()
        }

        binding.BTNDiv.setOnClickListener {
            divFun()
        }

        binding.BTNEqual.setOnClickListener {
            when(binding.calcOpTV.text){
                "+" -> addFun()
                "-" -> subFun()
                "x" -> multFun()
                "/" -> divFun()
            }
            binding.calcOpTV.text = ""
        }

        binding.BTNAc.setOnClickListener {
            binding.calcTV1.text = ""
            binding.calcTV2.text = ""
            binding.calcOpTV.text = ""
            result = 0.0F
            flag = 0
        }

        binding.BTNBack.setOnClickListener {
            binding.calcTV1.text = binding.calcTV1.text.toString().substring(0,(binding.calcTV1.text.toString().length - 1))

            if(binding.calcTV1.text == "" && binding.calcTV2.text == ""){
                result = 0.0F
            }
        }
    }

    private fun typeCalcTV(newString: String){
        val updatedString = (binding.calcTV1.text.toString() + newString)
        binding.calcTV1.text = updatedString
    }

    private fun addFun(){
        if (flag == 0){
            result = 0.0F
            flag = 1
        }

        if(flag == 1 && binding.calcTV1.text == "") {
            binding.calcOpTV.text = "+"
            return
        }

        result += binding.calcTV1.text.toString().toFloat()
        binding.calcTV2.text = result.toString()
        binding.calcTV1.text = ""
        binding.calcOpTV.text = "+"
    }

    private fun subFun(){
        if (flag == 0) {
            result = 2 * binding.calcTV1.text.toString().toFloat()
            flag = 1
        }

        if(flag == 1 && binding.calcTV1.text == "") {
            binding.calcOpTV.text = "-"
            return
        }

        result -= binding.calcTV1.text.toString().toFloat()
        binding.calcTV2.text = result.toString()
        binding.calcTV1.text = ""
        binding.calcOpTV.text = "-"
    }

    private fun multFun(){
        if (flag == 0){
            result = 1.0F
            flag = 1
        }

        if(flag == 1 && binding.calcTV1.text == "") {
            binding.calcOpTV.text = "x"
            return
        }

        result *= binding.calcTV1.text.toString().toFloat()
        binding.calcTV2.text = result.toString()
        binding.calcTV1.text = ""
        binding.calcOpTV.text = "x"
    }

    private fun divFun(){
        if (flag == 0){
            result = (binding.calcTV1.text.toString().toFloat()).pow(2)
            flag = 1
        }

        if(flag == 1 && binding.calcTV1.text == "") {
            binding.calcOpTV.text = "/"
            return
        }

        result /= binding.calcTV1.text.toString().toFloat()
        binding.calcTV2.text = result.toString()
        binding.calcTV1.text = ""
        binding.calcOpTV.text = "/"
    }
}