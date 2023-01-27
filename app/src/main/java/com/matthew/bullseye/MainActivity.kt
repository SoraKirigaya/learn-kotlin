package com.matthew.bullseye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import com.matthew.bullseye.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var sliderValue = 0
    private var targetValue = Random.nextInt(1, 100)

    private lateinit var binding: ActivityMainBinding

    //Testing pushing from android studio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.hitMeButton.setOnClickListener {
            Log.i("Button CLick Event", "You clicked the Hit Me Button")
            showResult()
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromuser: Boolean) {
                sliderValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        binding.targetTextView.text = targetValue.toString()
    }

    private fun pointsForCurrentRound(): Int {
        val maxScore = 100
        val difference = abs(targetValue - sliderValue)
        return maxScore - difference
    }

    private fun showResult() {
        val dialogTitle = getString(R.string.result_dialog_title)
        val dialogMessage =
            getString(R.string.result_dialog_message, sliderValue, pointsForCurrentRound())
        val builder = AlertDialog.Builder(this)

        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.setPositiveButton(R.string.result_dialog_button_text) { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }
}