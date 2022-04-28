package edu.itesm.nytimes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.itesm.nytimes.response.Libro
import edu.itesm.nytimes.databinding.ListaNylibroBinding

class LibroViewHolder(view: View):RecyclerView.ViewHolder(view){

    private val  binding = ListaNylibroBinding.bind(view)

    fun bind(property: Libro){
        val title = binding.tvTitle
        val imageView = binding.imageView
        val description = binding.tvDescription


        Glide.with(binding.root)
            .load(property.book_image)
            .circleCrop()
            .into(imageView)
        title.text = property.title
        description.text = property.description
    }
}