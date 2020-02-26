package com.example.barber_proe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    lateinit var  et_name:    EditText
    lateinit var  et_contras: EditText
    lateinit var  et_passC : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        et_name= findViewById(R.id.et_name) as EditText
        et_contras = findViewById(R.id.et_contras) as EditText
        et_passC = findViewById(R.id.et_passC) as EditText



// BOTON REGISTRAR
        et_register.setOnClickListener {
            var name: String = et_name.text.toString()
            var pass: String = et_contras.text.toString()
            var passComp: String = et_passC.text.toString()

            if (TextUtils.isEmpty(name)){
                et_name.error = "Ingrese nombre de usuario"
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(pass)) {
                et_contras.error = "Ingrese Contraseña"
                return@setOnClickListener
            }
            else if (name.isEmpty()  || pass.isEmpty() ) {
                Toast.makeText(this, " Completar datos", Toast.LENGTH_SHORT).show()
            }
            else if (pass != passComp) {
                Toast.makeText(this, " Contraseñas no coinciden", Toast.LENGTH_SHORT).show()

            }

            else if (pass.length < 6 ) {
                Toast.makeText(this, " La contrasena debe ser minimo de 6 caracteres", Toast.LENGTH_SHORT).show()
            }
            else if (pass.length >= 6) {

                val intentRegister = Intent(this, Login::class.java)
                intentRegister.putExtra("Correo",name)
                intentRegister.putExtra("pass",pass)
                setResult(RESULT_OK,intentRegister)
                finish()
            }


        }

    }


    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
        super.onBackPressed()
    }




}
