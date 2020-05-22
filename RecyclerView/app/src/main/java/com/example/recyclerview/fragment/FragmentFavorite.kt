package com.example.recyclerview.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.favorite_fragment.*
import kotlinx.android.synthetic.main.playing_fragment.*


class FragmentFavorite : Fragment() {
    lateinit var myMovie: ArrayList<MovieModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myMovie  = ArrayList<MovieModel>()
        // get data from MainActivity
        val activity: MainActivity = activity as MainActivity
          myMovie = activity.getData()
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_favorite.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MovieAdapter(context, myMovie, listener)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.listview)
        {
            rv_favorite.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = MovieAdapter(context, myMovie, listener)
            }
        }
        if(id == R.id.gridview)
        {
            rv_favorite.apply {
                layoutManager = GridLayoutManager(activity, 3, LinearLayoutManager.VERTICAL, false)
                adapter = MovieAdapter_Grid(context, myMovie, listener2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private val listener = object : MovieAdapter.MovieListener {
        override fun onClick(pos: Int, movie: MovieModel) {
            startProfileActivity(movie)
        }
        override fun favrite(pos: Int, movies: MovieModel) {
        }
    }

    private var listener2 = object : MovieAdapter_Grid.MovieListener {
        override fun onClick(pos: Int, movie: MovieModel) {
            startProfileActivity(movie)
        }
        override fun favrite(pos: Int, movies: MovieModel) {
        }
    }

// Start Profile of Movie
    private fun startProfileActivity(movie: MovieModel) {
        val intent = Intent (activity, MovieActivity2::class.java)
        intent.putExtra("title", movie.title)
        intent.putExtra("vote_average", movie.vote_average)
        intent.putExtra("release_date", movie.release_date)
        intent.putExtra("overview", movie.overview)
        intent.putExtra("poster_path", movie.getURL())
        activity?.startActivity(intent)
    }
}

