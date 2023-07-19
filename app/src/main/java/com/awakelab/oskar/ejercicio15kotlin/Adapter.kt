package com.awakelab.oskar.ejercicio15kotlin
//https://youtu.be/5xXTTdTAdU8 video con explicaicon RecyclearView similar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.awakelab.oskar.ejercicio15kotlin.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide


class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var listaPokemon = mutableListOf<Pokemon>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaPokemon[position]
        holder.bind(item)
    }

    fun setData(pokedex: List<Pokemon>) {
        this.listaPokemon = pokedex.toMutableList()
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private var imageView: ImageView? = null
        fun bind(pokemon: Pokemon) {
            binding.tvNombre.text = pokemon.nombre
            binding.tvTipo.text = pokemon.tipo
            binding.imageView.let {
                Glide.with(it)
                    .load(pokemon.imgUrl)
                    .into(binding.imageView)
            }


        }


    }

}