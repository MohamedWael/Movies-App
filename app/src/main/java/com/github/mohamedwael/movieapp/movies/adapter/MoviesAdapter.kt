package com.github.mohamedwael.movieapp.movies.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.github.mohamedwael.movieapp.R
import com.github.mohamedwael.movieapp.applevel.network.loadImage
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem
import com.github.mohamedwael.movieapp.applevel.toPixel
import com.makeramen.roundedimageview.RoundedImageView

class MoviesAdapter(val movies: List<MovieItem>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = View.inflate(parent.context, R.layout.movie_item_view, null)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(
            parent.context.toPixel(10f).toInt(),
            parent.context.toPixel(5f).toInt(),
            parent.context.toPixel(10f).toInt(),
            parent.context.toPixel(2f).toInt()
        )
        view.layoutParams = params
        return MoviesViewHolder(
            view
        )
    }


    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]

        holder.itemView.findViewById<TextView>(R.id.tvTest).text = movie.name

        val roundedImageView = holder.itemView.findViewById<RoundedImageView>(R.id.ivMovie)
        if (movie.image != null) {
            loadImage(
                movie.image,
                roundedImageView
            ).error(R.mipmap.ic_launcher).into(roundedImageView)
        } else {
            roundedImageView.visibility = View.GONE
        }
        holder.itemView.setOnClickListener{
            Toast.makeText(it.context, movie.name, Toast.LENGTH_SHORT).show()
        }
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}

