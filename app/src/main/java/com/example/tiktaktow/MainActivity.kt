package com.example.tiktaktow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tiktaktow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var flag = true
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.turnOf.text = "X"


        binding.reset.setOnClickListener {
            reset()
            }


    }


    @SuppressLint("SuspiciousIndentation")
    fun clickfun(view :View){

        val btnCurrent = view as Button

        if(btnCurrent.text ==""){
         count++

        if (flag){
            btnCurrent.text = "X"
            flag = false
            binding.turnOf.text = "O"
        }else{
            btnCurrent.text = "O"
            flag = true
            binding.turnOf.text = "X"
        }

        val b1 = binding.button1.text.toString()
        val b2 = binding.button2.text.toString()
        val b3 = binding.button3.text.toString()

        val b4 = binding.button4.text.toString()
        val b5 = binding.button5.text.toString()
        val b6 = binding.button6.text.toString()

        val b7 = binding.button7.text.toString()
        val b8 = binding.button8.text.toString()
        val b9 = binding.button9.text.toString()

            if (b1 == b2 && b2==b3 &&  b3!=""){
                alert(b1)
            }else  if (b4 == b5 && b5==b6 &&  b6!=""){
                alert(b4)
            }else  if (b7 == b8 && b8==b9 &&  b9!=""){
                alert(b7)
            }else  if (b1 == b5 && b5==b9 &&  b9!=""){
                alert(b1)
            }else  if (b3 == b5 && b5==b7 &&  b7!=""){
                alert(b3)
            }else  if (b2 == b5 && b5==b8 &&  b8!=""){
                alert(b2)
            }else  if (b1 == b4 && b4==b7 &&  b7!=""){
                alert(b1)
            }else  if (b3 == b6 && b6==b9 &&  b9!=""){
                alert(b3)
            } else if(count == 9){
                Toast.makeText(this , "Draw" , Toast.LENGTH_SHORT).show()
            }
        }
    }




    fun alert(result : String) {

        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(dialogView)

        if (result == "X"){
            dialogView.findViewById<TextView>(R.id.wishing).text = "Congratualtions"
            dialogView.findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.x)
        }else{
            dialogView.findViewById<TextView>(R.id.wishing).text = "Congratualtions"
            dialogView.findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.o)
        }

        alertDialogBuilder.setPositiveButton("Replay") { dialog, which ->
            reset()
            dialog.dismiss()
        }

        alertDialogBuilder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }




    fun reset(){
        flag = true
        count = 0

        binding.button1.text = ""
        binding.button2.text = ""
        binding.button3.text = ""

        binding.button4.text = ""
        binding.button5.text = ""
        binding.button6.text = ""

        binding.button7.text = ""
        binding.button8.text = ""
        binding.button9.text = ""
    }




}