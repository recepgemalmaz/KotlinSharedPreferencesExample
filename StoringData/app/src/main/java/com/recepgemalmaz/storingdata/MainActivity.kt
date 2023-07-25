package com.recepgemalmaz.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.recepgemalmaz.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var age: Int? = null
    var ageFramPref : Int? = null

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences -Xml - Key-Value
        sharedPreferences = this.getSharedPreferences("com.recepgemalmaz.storingdata", Context.MODE_PRIVATE)

        ageFramPref = sharedPreferences.getInt("age", -1)

        if(ageFramPref == -1) {
            binding.textView.text = "Your Age: "
        }
        else {
            binding.textView.text = "Your Age: $ageFramPref"
        }


        

    }
        fun save(view: View) {

            if (binding.editTextText.text.toString().toIntOrNull() != null) {
                age = binding.editTextText.text.toString().toInt()
                binding.textView.text = "Age: $age"
                sharedPreferences.edit().putInt("age", age!!).apply()
            } else {
                binding.textView.text = "Please enter a valid age"
            }

        }


        fun delete(view: View) {

            ageFramPref = sharedPreferences.getInt("age", -1)

            if(ageFramPref != -1) {
                sharedPreferences.edit().remove("age").apply()
                binding.textView.text = "Your Age: "
            }

        }


}