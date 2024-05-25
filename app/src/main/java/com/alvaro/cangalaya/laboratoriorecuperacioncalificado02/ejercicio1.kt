package com.alvaro.cangalaya.laboratoriorecuperacioncalificado02
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class ejercicio1 : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)
        imageView = findViewById(R.id.imageView)
    }
    fun mostrarImagen(view: View) {
        imageView.visibility = View.VISIBLE
    }
    fun ocultarImagen(view: View) {
        imageView.visibility = View.INVISIBLE
    }
}
