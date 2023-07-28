package com.example.amplifyfunctions.ui.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.amplifyfunctions.R
import com.example.amplifyfunctions.databinding.ActivityAddBookBinding
import com.example.amplifyfunctions.databinding.ActivityMainBinding
import com.example.amplifyfunctions.databinding.FragmentBooksBinding

class AddBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartAddBook.setOnClickListener {
            val bookName = binding.edtBookName.text.toString()
            val bookDescription = binding.edtBookDescription.text.toString()
            val author = binding.edtBookDescription.text.toString()

            // TODO: Implement add method
        }
    }
}