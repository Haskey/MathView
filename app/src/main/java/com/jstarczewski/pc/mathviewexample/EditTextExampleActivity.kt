package com.jstarczewski.pc.mathviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jstarczewski.pc.mathviewexample.databinding.ActivityEditTextExampleBinding

class EditTextExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mvEditTextExample.textZoom = 70
        binding.mvEditTextExample.backgroundColor = "#EEEEEE"

        binding.btShowEquation.setOnClickListener {

            binding.mvEditTextExample.text = binding.etEquation.text.toString()

        }
        binding.btShowRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewExampleActivity::class.java))
        }
    }
}
