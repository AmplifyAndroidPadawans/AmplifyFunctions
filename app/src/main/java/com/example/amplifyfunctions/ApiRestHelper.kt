package com.example.amplifyfunctions

import android.util.Log
import com.amplifyframework.api.rest.RestOptions
import com.amplifyframework.core.Amplify

class ApiRestHelper {

    fun getBooks(callback: (booksList: List<Book>) -> Unit) {
        val request = RestOptions.builder()
            .addPath("/books")
            .build()

        Amplify.API.get(request,
            { response ->
                Log.i("ApiRestHelper", "GET succeeded ${String(response.data.rawBytes)}")
                callback(String(response.data.rawBytes).toBookList())
            },
            {
                Log.e("ApiRestHelper", "GET failed.", it)
                callback(listOf())
            }
        )
    }

    fun getBook(id: String, callback: (books: Book?) -> Unit) {
        val request = RestOptions.builder()
            .addPath("/books/$id")
            .build()

        Amplify.API.get(request,
            { response ->
                Log.i("ApiRestHelper", "GET succeeded ${String(response.data.rawBytes)}")
                callback(String(response.data.rawBytes).toBook())
            },
            {
                Log.e("ApiRestHelper", "GET failed.", it)
                callback(null)
            }
        )
    }

    fun postBook(book: Book) {
        val options = RestOptions.builder()
            .addPath("/books")
            .addBody(book.toByteArray())
            .build()

        Amplify.API.post(options,
            { Log.i("ApiRestHelper", "POST succeeded: ${String(it.data.rawBytes)}") },
            { Log.e("ApiRestHelper", "POST failed", it) }
        )
    }
}