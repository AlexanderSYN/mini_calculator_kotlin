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
        
        // get id all editText
        val etNum1 = findViewById<EditText>(R.id.etFirstNum)
        val etNum2 = findViewById<EditText>(R.id.etSecondNum)
        val etSymbol = findViewById<EditText>(R.id.etSymbol)

        val et1 = findViewById<EditText>(R.id.et1)

        // get id btn
        val btnPlus = findViewById<Button>(R.id.btnPl)
        val btnMinus = findViewById<Button>(R.id.btnMin)
        val btnMultiply = findViewById<Button>(R.id.btnMul)
        val btnDivide = findViewById<Button>(R.id.btnDiv)
        val btnEquals = findViewById<Button>(R.id.btnEquals)
        val btnClear = findViewById<Button>(R.id.btnC)

        btnPlus.setOnClickListener {
            num1 = et1.text.toString()
            etNum1.setText(num1.toString())
            etSymbol.setText("+")

            operator = "plus"
            et1.setHint("0")
            et1.text.clear()
        }

        btnMinus.setOnClickListener {
            num1 = et1.text.toString()
            etNum1.setText(num1.toString())
            etSymbol.setText("-")

            operator = "minus"
            et1.setHint("0")
            et1.text.clear()
        }

        btnMultiply.setOnClickListener {
            num1 = et1.text.toString()
            etNum1.setText(num1.toString())
            etSymbol.setText("*")

            operator = "multiply"
            et1.setHint("0")
            et1.text.clear()
        }

        btnDivide.setOnClickListener {
            num1 = et1.text.toString()
            etNum1.setText(num1.toString())
            etSymbol.setText("/")

            operator = "divide"
            et1.setHint("0")
            et1.text.clear()
        }

        btnClear.setOnClickListener {
            et1.text.clear()
        }

        btnEquals.setOnClickListener {
           try {
               num2 = et1.text.toString()
               etNum2.setText(num2.toString())
               if (operator == "plus") answ = num1.toDouble() + num2.toDouble()
               else if (operator == "minus") answ = num1.toDouble() - num2.toDouble()
               else if (operator == "multiply") answ = num1.toDouble() * num2.toDouble()
               else if (operator == "divide") {
                   answ = num1.toDouble() / num2.toDouble()
                   if (answ.toString() == "Infinity" || answ.toString() == "-Infinity") throw ArithmeticException("нельзя делить на 0")
               }


               et1.setText(answ.toString())
           }
           catch (AE: ArithmeticException) {
               et1.text.clear()
               et1.setHint("нельзя делить на 0")
           }
           catch (e : Exception) {
               et1.text.clear()
               et1.setHint("Ошибка: " + e)
           }
        }

    }
}