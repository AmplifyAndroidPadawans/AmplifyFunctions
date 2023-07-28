package com.example.amplifyfunctions.ui.authors

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amplifyfunctions.databinding.FragmentAuthorsBinding

class AuthorsFragment : Fragment(), AuthorsInterface {

    private lateinit var binding: FragmentAuthorsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnStartAddAuthor.setOnClickListener(::goAddAuthor)

        binding.rvAuthors.layoutManager = LinearLayoutManager(this.context)
        binding.rvAuthors.adapter = AuthorsAdapter(listOf(), this)


        return root
    }

    private fun goAddAuthor(view: View) {
        val intent = Intent(this.context, AddAuthorActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun editAuthor(author: T) {

    }

    override fun removeAuthor(author: T) {

    }
}