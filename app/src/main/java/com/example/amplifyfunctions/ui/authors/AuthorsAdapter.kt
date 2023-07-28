package com.example.amplifyfunctions.ui.authors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amplifyfunctions.R

class AuthorsAdapter(private val authorsList: List<T>, private val listener: AuthorsInterface):
    RecyclerView.Adapter<AuthorsAdapter.AuthorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AuthorsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.author_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AuthorsViewHolder, position: Int) {
        val item = authorsList[position]
        holder.tvAuthorName.text = item.title

        holder.btnEditAuthor.setOnClickListener { listener.editAuthor(item) }
        holder.btnDeleteAuthor.setOnClickListener { listener.removeAuthor(item) }
    }

    override fun getItemCount(): Int = authorsList.size


    inner class AuthorsViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val tvAuthorName: TextView = itemView.findViewById(R.id.tv_authorName)
        val btnEditAuthor: Button = itemView.findViewById(R.id.btn_editAuthor)
        val btnDeleteAuthor: Button = itemView.findViewById(R.id.btn_deleteAuthor)
    }
}

interface AuthorsInterface {
    fun editAuthor(author: T)
    fun removeAuthor(author: T)
}