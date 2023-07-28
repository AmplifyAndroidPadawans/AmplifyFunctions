package com.example.amplifyfunctions.ui.books

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amplifyfunctions.databinding.FragmentBooksBinding

class BooksFragment : Fragment(), BooksInterface {

    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnStartAddBook.setOnClickListener(::goAddBook)

        binding.rvBooks.layoutManager = LinearLayoutManager(this.context)
        binding.rvBooks.adapter = BooksAdapter(listOf(), this)

        // TODO: add get books list

        return root
    }

    private fun goAddBook(view: View) {
        val intent = Intent(this.context, AddBookActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun editBook(book: T) {
        // TODO: edit selected book
    }

    override fun removeBook(book: T) {
        // TODO: remove selected book
    }
}