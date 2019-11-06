package com.example.muko.ifalbitkilerkotlinlistview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tumBitkiler: ArrayList<Bitkiler>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiHazirla()

        var myBaseAdapter = BitkilerAdapter(this, tumBitkiler)
        listview_bitkiler.adapter = myBaseAdapter

        listview_bitkiler.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this@MainActivity, BitkilerHakkindaActivity::class.java)
            intent.putExtra("tiklanilanpozisyon",position)
            intent.putExtra("tumBitkiBilgileri",tumBitkiler)
            startActivity(intent)
        }
    }

    private fun veriKaynagiHazirla() {

        tumBitkiler = ArrayList<Bitkiler>(12)

        var bitkiAdi = resources.getStringArray(R.array.bitki_ismi)
        var bitkiVitamini = resources.getStringArray(R.array.bitki_vitamini)
        var bitkiResmi = arrayOf(
            R.drawable.corekotu,
            R.drawable.adacayi,
            R.drawable.isirganotu,
            R.drawable.zencefil,
            R.drawable.meyankoku,
            R.drawable.aloevera,
            R.drawable.papatya,
            R.drawable.sarimsak,
            R.drawable.nane,
            R.drawable.biberiye,
            R.drawable.maydonoz,
            R.drawable.karabasotu
        )
        var bitkiBuyukRes = arrayOf( R.drawable.corekotubuyukres,
            R.drawable.adacayibuyukres,
            R.drawable.isirganotubuyukres,
            R.drawable.zencefilbuyukres,
            R.drawable.meyankokubuyukres,
            R.drawable.aloeverabuyukres,
            R.drawable.papatyabuyukres,
            R.drawable.sarimsakbuyukres,
            R.drawable.nanebuyukres,
            R.drawable.biberiyebuyukres,
            R.drawable.maydonozbuyukres,
            R.drawable.karabasbuyukres)
        var bitkiGenelOzellikleri = resources.getStringArray(R.array.bitkigenelOzellikleri)

        for (i in 0..11){
            var atanacakBitki = Bitkiler(bitkiAdi[i], bitkiVitamini[i], bitkiResmi[i], bitkiBuyukRes[i], bitkiGenelOzellikleri[i])
            tumBitkiler.add(atanacakBitki)
        }
    }
}
