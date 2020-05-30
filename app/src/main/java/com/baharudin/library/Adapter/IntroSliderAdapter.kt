package com.baharudin.library.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.library.Model.IntroSlider
import com.baharudin.library.R

class IntroSliderAdapter(private var introSliders : List<IntroSlider>): RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>() {

    inner class IntroSlideViewHolder(view:View) : RecyclerView.ViewHolder(view){
        private var tvSlogan = view.findViewById<TextView>(R.id.slogan1)
        private var tvDescription = view.findViewById<TextView>(R.id.description)
        private var ivIcon = view.findViewById<ImageView>(R.id.icon_slider)

        fun bind(introSlider: IntroSlider){
            tvSlogan.text = introSlider.Slogan
            tvDescription.text = introSlider.Descriptopn
            ivIcon.setImageResource(introSlider.Icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_slider,parent,false))
    }

    override fun getItemCount(): Int = introSliders.size

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSliders[position])
    }
}