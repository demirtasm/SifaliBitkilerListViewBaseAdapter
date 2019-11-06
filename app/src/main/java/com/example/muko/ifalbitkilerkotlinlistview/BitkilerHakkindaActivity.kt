package com.example.muko.ifalbitkilerkotlinlistview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bitkiler_hakkinda.*
import kotlinx.android.synthetic.main.bitkiler_layout.*

class BitkilerHakkindaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitkiler_hakkinda)

        var position = intent.extras.get("tiklanilanpozisyon") as Int
        var tumBitkiBilgileri = intent.extras.get("tumBitkiBilgileri") as ArrayList<Bitkiler>
       /* Toast.makeText(
            this,
            "tiklanilan oge pos : " + position + "tum bitki sayisi" + tumBurcBilgileri.size,
            Toast.LENGTH_SHORT
        ).show()*/

        header.setImageResource(tumBitkiBilgileri.get(position).bitkiBuyukRes)
        tvBitkiOzellikleri.setText(tumBitkiBilgileri.get(position).bitkiGenelOzellik)

        setSupportActionBar(anim_toolbar)
        collapsing_toolbar.title = tumBitkiBilgileri.get(position).bitkiBaslik

        var bitmap : Bitmap = BitmapFactory.decodeResource(resources, tumBitkiBilgileri.get(position).bitkiBuyukRes)
        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette) {
                var color = palette?.getDarkVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor = color

            }

        })

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
