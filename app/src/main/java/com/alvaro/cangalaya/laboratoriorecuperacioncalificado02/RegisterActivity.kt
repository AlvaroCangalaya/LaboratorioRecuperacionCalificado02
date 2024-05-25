package com.alvaro.cangalaya.laboratoriorecuperacioncalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alvaro.cangalaya.laboratoriorecuperacioncalificado02.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()
    }

    private fun observeComponents() {
        binding.btnGuardar.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                goDetailsActivity()
            }
        }
    }

    private fun goDetailsActivity() {
        val nombre = binding.tvNombre.text.toString()
        val apellido = binding.tvApellido.text.toString()
        val celular = binding.tvCelular.text.toString()
        val direccion = binding.tvDireccion.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Nombre_key, nombre)
        intent.putExtra(Apellido_key, apellido)
        intent.putExtra(Celular_Key, celular)
        intent.putExtra(Direccion_Key, direccion)
        startActivity(intent)
    }

    private fun isEmptyInputs(): Boolean {
        return binding.tvNombre.text.isEmpty() ||
                binding.tvApellido.text.isEmpty() ||
                binding.tvCelular.text.isEmpty() ||
                binding.tvDireccion.text.isEmpty()
    }
}

