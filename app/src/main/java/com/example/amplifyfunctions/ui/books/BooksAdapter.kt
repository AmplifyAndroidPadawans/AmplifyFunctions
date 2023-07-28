package com.example.amplifyfunctions.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amplifyfunctions.R

class BooksAdapter(private val booksList: List<T>, private val listener: BooksInterface):
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BooksViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.book_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = booksList[position]
        holder.tvBookTitle.text = item.title
        holder.tvBookDescription.text = item.description

        holder.btnEditBook.setOnClickListener { listener.editBook(item) }
        holder.btnDeleteBook.setOnClickListener { listener.removeBook(item) }
    }

    override fun getItemCount(): Int = booksList.size


    inner class BooksViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val tvBookTitle: TextView = itemView.findViewById(R.id.tv_bookTitle)
        val tvBookDescription: TextView = itemView.findViewById(R.id.tv_bookDescription)
        val btnEditBook: Button = itemView.findViewById(R.id.btn_editBook)
        val btnDeleteBook: Button = itemView.findViewById(R.id.btn_deleteBook)
    }
}

interface BooksInterface {
    fun editBook(book: T)
    fun removeBook(book: T)
}