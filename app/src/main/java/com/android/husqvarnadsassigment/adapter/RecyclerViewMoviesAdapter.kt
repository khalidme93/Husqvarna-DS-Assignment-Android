package com.android.husqvarnadsassigment.adapter


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.husqvarnadsassigment.Communicator
import com.android.husqvarnadsassigment.models.MoviesRecyclerData
import com.squareup.picasso.Picasso


class RecyclerViewMoviesAdapter : RecyclerView.Adapter<RecyclerViewMoviesAdapter.MyViewHolder>(){
    companion object {
        var id:Int = 0
    }
    var items = ArrayList<MoviesRecyclerData>()
    private lateinit var listener: Communicator

    fun setUpdatedData(items : ArrayList<MoviesRecyclerData>) {
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val photo = view.findViewById<ImageView>(com.khalidelkilany.husqvarnadsassigment.R.id.poster_path_movie)

        fun bind(dataMovies : MoviesRecyclerData) {


            val url  = "https://image.tmdb.org/t/p/w500/"+dataMovies.poster_path

            Picasso.get()
                .load(url)
                .into(photo)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.khalidelkilany.husqvarnadsassigment.R.layout.recycler_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Math.min(items.size, 10);
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listener = holder.itemView.context as Communicator

        holder.bind(items[position])
        holder.itemView.setOnClickListener {
                    id = items[position].id
                    Log.d("idAdapter", id.toString())
                    listener?.passDataCom(id)
        }
    }
}