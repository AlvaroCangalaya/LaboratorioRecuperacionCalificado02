package com.alvaro.cangalaya.laboratoriorecuperacioncalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alvaro.cangalaya.laboratoriorecuperacioncalificado02.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()

        intent.extras?.let {
            showData(it)
        }
    }

    private fun listenerComponentUi() {
        binding.btnWSP.setOnClickListener {
            WSP()
        }
        binding.btnTelefono.setOnClickListener {
            Llamar()
        }
        binding.btnGPS.setOnClickListener {
            openGoogleMaps()
        }
    }

    private fun showData(paraExtras: Bundle) {
        val fullName = paraExtras.getString(Nombre_key)
        val apellidos = paraExtras.getString(Apellido_key)
        val celular = paraExtras.getString(Celular_Key)
        val direccion = paraExtras.getString(Direccion_Key)

        binding.tvNombre.text = fullName
        binding.tvApellido.text = apellidos
        binding.tvCelular.text = celular
        binding.tvDireccion.text = direccion
    }

    private fun WSP() {
        val fullName = binding.tvNombre.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$fullName")
        startActivity(intent)
    }

    private fun Llamar() {
        val phoneNumber = binding.tvCelular.text.toString().trim()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phoneNumber")
        startActivity(intent)
    }

    private fun openGoogleMaps() {
        val address = binding.tvDireccion.text.toString()
        val geoUri = "http://maps.google.com/maps?q=$address"
        val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
        startActivity(mapIntent)
    }
}
