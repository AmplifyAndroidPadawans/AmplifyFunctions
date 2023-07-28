package com.example.amplifyfunctions.ui.authors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amplifyfunctions.R
import com.example.amplifyfunctions.databinding.ActivityAddAuthorBinding
import com.example.amplifyfunctions.databinding.ActivityAddBookBinding

class AddAuthorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddAuthorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_author)

        binding = ActivityAddAuthorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartAddAuthor.setOnClickListener {
            val bookName = binding.edtAuthorName.text.toString()
            val bookDescription = binding.edtAuthorLastName.text.toString()

            // TODO: Implement add method
        }
    }
}