package com.android.husqvarnadsassigment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.husqvarnadsassigment.Communicator
import com.android.husqvarnadsassigment.models.MovieDetailsRecyclerData
import com.khalidelkilany.husqvarnadsassigment.R
import com.squareup.picasso.Picasso



class RecyclerViewMoviesDetailsAdapter : RecyclerView.Adapter<RecyclerViewMoviesDetailsAdapter.MyViewHolder>(){
    private lateinit var listener: Communicator

    var items = arrayOf(MovieDetailsRecyclerData("", "", "", "", ""))

    fun setUpdatedData(items: MovieDetailsRecyclerData) {
        this.items = arrayOf(items)

        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val photo = view.findViewById<ImageView>(R.id.moviePoster)
        val title = view.findViewById<TextView>(R.id.movieTitle)
        val releasDate = view.findViewById<TextView>(R.id.releasDate)
        val overView = view.findViewById<TextView>(R.id.overView)
        val VoteAverage = view.findViewById<TextView>(R.id.VoteAverage)








        fun bind(dataMovies : MovieDetailsRecyclerData) {

            title.text = dataMovies.original_title
            releasDate.text = dataMovies.release_date
            overView.text = dataMovies.overview
            VoteAverage.text = dataMovies.vote_average.toString()
            Log.d("dataMovies", title.text.toString())
            val url  = "https://image.tmdb.org/t/p/w500/"+ dataMovies.poster_path
            Picasso.get()
                .load(url)
                .into(photo)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        listener = parent.context as Communicator

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row_movie_details, parent, false)
        val backButton = view.findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            listener.backButton()
        }


        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //set every single item in on position
        holder.bind(items[position])
    }
}

