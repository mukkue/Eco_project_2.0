package com.example.eco_project_20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Forget_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        var queue=Volley.newRequestQueue(this)
        var email1:EditText=findViewById(R.id.editTextTextEmailAddress)
        var pass1:EditText=findViewById(R.id.editTextTextPassword)
        var btn:Button=findViewById(R.id.button)
        btn.setOnClickListener {

            var stringRequest=StringRequest(Request.Method.GET,
                "http://yashs.xyz/WebService1.asmx/Froget_page?email="+email1.text.toString()+"&pass="+pass1.text.toString(),
                { Response ->

                    Toast.makeText(applicationContext, "Update Succesfully", Toast.LENGTH_SHORT).show()

                 },
                {
                    //Toast.makeText(applicationContext, ""+ error, Toast.LENGTH_SHORT).show()
                })
              queue.add(stringRequest)
        }
    }
}