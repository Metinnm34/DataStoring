package com.han.datastoring

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.han.datastoring.databinding.ActivityMainBinding

// SharedPreferences - XML Key-Value
class MainActivity : AppCompatActivity() {

    

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences başlatılması
        sharedPreferences = this.getSharedPreferences("com.han.datastoring", Context.MODE_PRIVATE)

        val userTshirtPref = sharedPreferences.getInt("t-shirt",18)

        if (userTshirtPref  == 18 ){
            binding.textView.text = " Number Of T-shirts: "
        } else {
            binding.textView.text = "Number of T-shirts : ${userTshirtPref}"
        }

    }

    //Save Yani Veri Kaydetme İşlemi

    fun saveData(view: View) {
        val myTshirtNumber = binding.editText.text.toString().toIntOrNull()
        binding.textView.text = "Number of T-shirts: $myTshirtNumber"

        if (myTshirtNumber != null) {
            sharedPreferences.edit().putInt("t-shirt", myTshirtNumber).apply()
        }
    }

    //Delete Işlemi

    fun deleteData(view: View) {
        sharedPreferences.edit().remove("t-shirt").apply()
        binding.textView.text = "Number of T-shirts: "
    }




}
