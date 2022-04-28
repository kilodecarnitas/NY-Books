package edu.itesm.nytimes.response


data class Libro(val rank: Int,
                val title: String,
                val description: String,
                val book_image: String)

data class NewResponse(
    val status: String,
    val results: Libros
)

data class Libros(
    val books: List<Libro>
)

