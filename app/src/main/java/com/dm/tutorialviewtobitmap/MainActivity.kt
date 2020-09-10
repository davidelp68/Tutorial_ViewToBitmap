package com.dm.tutorialviewtobitmap

import android.graphics.Bitmap                          //Importazione della Classe: Bitmap
import android.graphics.Canvas                          //Importazione della Classe: Canvas
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView                         //Importazione della Classe: ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var bnImage: Button? = null
    var vColor: View? = null
    var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnImage = findViewById(R.id.button)
        vColor = findViewById(R.id.view)
        image = findViewById(R.id.imageView)

        //utilizzo della SeekBar per modificare il colore della View
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                vColor!!.setBackgroundColor(Color.rgb(progress, 74, 133))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        //pulsante che crea l'immagine Bitmap della View
        bnImage!!.setOnClickListener {
            val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            //associazione della View (oggetto) alla variabile canvas
            view.draw(canvas)
            //impostazione dell'immagine nella View imageView
            imageView.setImageBitmap(bitmap)
        }
    }
}
