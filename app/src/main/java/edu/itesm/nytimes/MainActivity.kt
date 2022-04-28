// Aldo Fernando Ortiz Mejía - A01654725
// Diego Ramírez Levy - A01367771

package edu.itesm.nytimes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.itesm.nytimes.adapter.LibrosAdapter
import edu.itesm.nytimes.databinding.ActivityMainBinding
import edu.itesm.nytimes.mvvm.LibrosMVVM
import edu.itesm.nytimes.response.Libro

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: LibrosAdapter
    private lateinit var binding: ActivityMainBinding
    private  val libros = mutableListOf<Libro>()
    private lateinit var viewModel: LibrosMVVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initViewModel()
        viewModel.newAPICall()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(LibrosMVVM::class.java)
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {
                Log.v("libros", it.results.books.toString())
                adapter.setLibro(it.results.books)
                adapter.notifyDataSetChanged()
            }
        }
    }
    private fun initAdapter(){
        adapter = LibrosAdapter(libros)
        binding.listaLibros.layoutManager =  LinearLayoutManager(this)
        binding.listaLibros.adapter = adapter
    }
}