package com.example.mini_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var num1 : String = "0"
    private var num2 : String = "0"
    private var answ : Double = 0.0

    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // get id tv1
        val tv1 : EditText = findViewById(R.id.tv1)

        // get id btn
        val btnPlus : Button = findViewById(R.id.btnPlus)
        val btnMinus : Button = findViewById(R.id.btnMinus)
        val btnMultiply : Button = findViewById(R.id.btnMult)
        val btnDivide : Button = findViewById(R.id.btnDivide)
        val btnEquals : Button = findViewById(R.id.btnEquals)

        btnPlus.setOnClickListener {
            num1 = tv1.text.toString()
            operator = "plus"
            tv1.setText("")
        }

        btnMinus.setOnClickListener {
            num1 = tv1.text.toString()
            operator = "minus"
            tv1.setText("")
        }

        btnMultiply.setOnClickListener {
            num1 = tv1.text.toString()
            operator = "multiply"
            tv1.setText("")
        }

        btnDivide.setOnClickListener {
            num1 = tv1.text.toString()
            operator = "divide"
            tv1.setText("")
        }

        btnEquals.setOnClickListener {
            num2 = tv1.text.toString()
            if (operator == "plus")
                answ = num1.toDouble() + num2.toDouble()
            else if (operator == "minus")
                answ = num1.toDouble() - num2.toDouble()
            else if (operator == "multiply")
                answ = num1.toDouble() * num2.toDouble()
            else if (operator == "divide")
                answ = num1.toDouble() / num2.toDouble()

            tv1.setText(answ.toString())
        }

    }
}