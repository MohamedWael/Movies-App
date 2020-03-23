package com.github.mohamedwael.core.domain

class Movies : ArrayList<Movie>()

data class Movie(
    val image: String? = null,
    val name: String? = null,
    val description: String? = null,
    val id: Int? = null
)