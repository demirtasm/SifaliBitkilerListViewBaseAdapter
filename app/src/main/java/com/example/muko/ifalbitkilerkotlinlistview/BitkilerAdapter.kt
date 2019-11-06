package com.example.muko.ifalbitkilerkotlinlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.bitkiler_layout.view.*

class BitkilerAdapter(context: Context, tumBitkiBilgileri : ArrayList<Bitkiler>) : BaseAdapter() {
    var tumBitkiler: ArrayList<Bitkiler>
    var context: Context

    init {
        this.tumBitkiler = tumBitkiBilgileri
        this.context = context

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        /**
         * her bir saatırı oluştururken tetiklenen metot
         */
        var layoutView = convertView
        var viewHolder : viewHolder
        if (layoutView == null) {
            var inflater = LayoutInflater.from(context)
            layoutView = inflater.inflate(R.layout.bitkiler_layout, parent, false)
            viewHolder = viewHolder(layoutView)
            layoutView.tag = viewHolder
        }else{
            viewHolder = layoutView.getTag() as viewHolder
        }
        layoutView?.img_bitki?.setImageResource(tumBitkiler.get(position).bitkiResim)
        layoutView?.txt_baslik?.setText(tumBitkiler.get(position).bitkiBaslik)
        layoutView?.txt_vitamin?.setText(tumBitkiler.get(position).bitkiVit)

        return layoutView
    }

    override fun getItem(position: Int): Any {
        /**
         * ilgili satırdaki elemana nasıl ulaşılacağına dair bilgi veren metot
         */

        return tumBitkiler.get(position)
    }

    override fun getItemId(position: Int): Long {
        /**
         * listedeki veri tabanlarıyla uğraşırken kullanılmalı
         */

        return 0
    }

    override fun getCount(): Int {
        /**
         * listenin kaç elemanlı olduğu bilgisi
         */

        return tumBitkiler.size
    }

}

class viewHolder(layoutView: View) {
    var bitkiResim: ImageView
    var bitkiBaslik: TextView
    var bitkiVit: TextView

    init {
        this.bitkiBaslik = layoutView.txt_baslik
        this.bitkiResim = layoutView.img_bitki
        this.bitkiVit = layoutView.txt_vitamin
    }
}