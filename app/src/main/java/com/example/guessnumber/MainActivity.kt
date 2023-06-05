package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.guessnumber.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var guessNumber : TextView
    private var guessRandom : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Gan gia tri

        guessNumber = binding.guessNumber
        guessRandom = generateRandomNumber()
        binding.guessRandom.text = guessRandom.toString()
        // Tạo random sooss là
        binding.guessRandom.visibility = View.INVISIBLE
        binding.alert.visibility = View.GONE

        binding.reset.setOnClickListener{
            binding.guessNumber.setText("")
            binding.guessRandom.visibility = View.INVISIBLE
            binding.alert.visibility = View.GONE
            guessRandom = generateRandomNumber()
            binding.guessRandom.text = guessRandom.toString()
        }

        binding.guess.setOnClickListener{

            if (guessNumber.text.toString() == binding.guessRandom.text.toString() )
            {
                binding.guessRandom.visibility = View.VISIBLE
                binding.alert.visibility = View.VISIBLE
                binding.alert.setText(R.string.success)
                binding.alert.setTextColor(resources.getColor(R.color.success))
            }
            else if (guessNumber.text != binding.guessRandom.text)
            {
                binding.guessRandom.visibility = View.VISIBLE
                binding.alert.visibility = View.VISIBLE
                binding.alert.setText(R.string.failed)
                binding.alert.setTextColor(resources.getColor(R.color.failed))
            }
        }
    }


     fun generateRandomNumber() : Int{
             return Random.nextInt(0,100)
    }


}