package com.example.a_i_vv_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a_i_vv_rv.databinding.MainRvContentBinding

class MainAdapter(private val dataset: ArrayList<Song>,
                  val onClickListener: (Song) -> Unit): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    // Untuk bind data kepada view PER ITEM di RecyclerView
    inner class ViewHolder(private val view: MainRvContentBinding) : RecyclerView.ViewHolder(view.root){
        fun bindData( songData: Song) {
            view.tvArtist.text = songData.name
            view.tvTitle.text = songData.title
        }
    }
    // Membentuk View tersebut , dalam kasus ini view dari ViewHolderya
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder: MainRvContentBinding = MainRvContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewHolder)
    }

    // Totalnya dingunakan untuk RV ketika sudah tidak ada ITEMS yang dapat ditampilkan
    override fun getItemCount(): Int {
        return dataset.size
    }

    // Bind ViewHolder dengan data dari Adapter
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val songData: Song = dataset[position]
        holder.bindData(songData)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onClickListener(songData)
            }
        })
    }

}