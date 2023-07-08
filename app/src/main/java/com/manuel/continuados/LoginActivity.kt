package com.manuel.continuados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.manuel.continuados.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Desactivar el botón de inicio de sesión al inicio
        binding.btnLogin.isEnabled = false

        binding.tilEmail.editText?.addTextChangedListener { text ->
            estadobtnLogin()
        }

        binding.tilPassword.editText?.addTextChangedListener { text ->
            estadobtnLogin()
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()

            if (email == "user@gmail.com" && password == "1234") {
                val intent = Intent(this, MainActivity::class.java)
                val message="Acceso autorizado!"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            } else {
                val errorMessage="credenciales no válidas"
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                // Realizar acciones en caso de credenciales incorrectas, como mostrar un mensaje de error
            }
        }
    }

    private fun estadobtnLogin() {
        val isEmailValid = binding.tilEmail.editText?.text?.isNotEmpty() == true
        val isPasswordValid = binding.tilPassword.editText?.text?.isNotEmpty() == true

        binding.btnLogin.isEnabled = isEmailValid && isPasswordValid
    }
}