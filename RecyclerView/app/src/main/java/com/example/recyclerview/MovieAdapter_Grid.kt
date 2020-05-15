package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter_Grid(val ctx: Context, val movies: ArrayList<MovieModel>, val listener: MovieListener): RecyclerView.Adapter<MovieAdapter_Grid.MovieVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val view = LayoutInflater.from(ctx).inflate(R.layout.gridview_movie_item, parent, false)

        return MovieVH(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieAdapter_Grid.MovieVH, position: Int) {
        val movie = movies[position]

        holder.tvTitle.text = movie.title
        holder.tvRating.text = movie.vote_average.toString()
        holder.tvRelease.text = movie.release_date

        Glide.with(ctx)
            .load(movie.getURL())
            .centerCrop()
            .into(holder.ivImage)
        holder.itemView.setOnClickListener{
            listener.onClick(position, movie)
        }
    }
    //    var listener :MovieListener? = null
//    interface MovieListener {
//        fun onClick(movie: MovieModel)
//    }
    class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.Title2)
        val tvRating = itemView.findViewById<TextView>(R.id.Rating2)
        val tvRelease = itemView.findViewById<TextView>(R.id.Releasedate2)
        val ivImage = itemView.findViewById<ImageView>(R.id.ImageMovie2)
    }
    interface MovieListener {
        fun onClick(pos: Int, movie: MovieModel)
    }

}