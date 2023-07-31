package com.example.amplifyfunctions.ui.books

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amplifyfunctions.ApiRestHelper
import com.example.amplifyfunctions.Book
import com.example.amplifyfunctions.databinding.FragmentBooksBinding

class BooksFragment : Fragment(), BooksInterface {

    private lateinit var binding: FragmentBooksBinding
    private lateinit var adapter: BooksAdapter

    private var booksList: List<Book> = listOf()

    private val api by lazy {
        ApiRestHelper()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartAddBook.setOnClickListener(::addBook)

        binding.rvBooks.layoutManager = LinearLayoutManager(this.context)
        adapter = BooksAdapter(booksList, this)
        binding.rvBooks.adapter = adapter

        api.getBooks(::handleGetBooks)
        //api.getBook("f7dc4090-9611-47a5-a845-863501a5fcd6", ::handleGetBook)
    }

    private fun handleGetBook(book: Book?) {

    }

    private fun addBook(view: View) {
        api.postBook(
            Book(
                title = "Other book",
                description = "This a new method to create books",
                author = "David Perez"
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun handleGetBooks(booksList: List<Book>) {
        activity?.runOnUiThread {
            adapter.updateAdapter(booksList)
        }
    }

    private fun goAddBook(view: View) {
        val intent = Intent(this.context, AddBookActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun editBook(book: Book) {
        // TODO: edit selected book
    }

    override fun removeBook(book: Book) {
        // TODO: remove selected book
    }
}