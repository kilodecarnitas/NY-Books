package edu.itesm.nytimes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.itesm.nytimes.R
import edu.itesm.nytimes.response.Libro

class LibrosAdapter(var libros: List<Libro>): RecyclerView.Adapter<LibroViewHolder>() {

    fun setLibro(books: List<Libro>){
        libros = books.take(10)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.lista_nylibro, parent, false )
        return LibroViewHolder(view)

    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libroURl = libros[position]
        holder.bind(libroURl)
    }

    override fun getItemCount(): Int {

        return  libros.size
    }
}