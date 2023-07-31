package com.example.amplifyfunctions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.UUID


data class Book (
    private val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val author: String
) {
    fun toByteArray(): ByteArray =
        "{\"id\":\"$id\",\"title\":\"$title\",\"description\":\"$description\",\"author\":\"$author\"}".toByteArray()
}

fun String.toBook(): Book {
    val response = Gson().fromJson(this, ResponseModel::class.java)
    return Gson().fromJson(response.body, Book::class.java)
}

fun String.toBookList(): List<Book> {
    val response = Gson().fromJson(this, ResponseModel::class.java)
    val listType: Type = object : TypeToken<List<Book>>() {}.type
    return Gson().fromJson(response.body, listType)
}

private data class ResponseModel(
    val statusCode: Int,
    val url: String,
    val body : String,
)
