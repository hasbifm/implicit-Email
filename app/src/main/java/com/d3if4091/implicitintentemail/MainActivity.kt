package com.d3if4091.implicitintentemail

import android.content.Intent
import android.content.Intent.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.d3if4091.implicitintentemail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    var emailAdd = ""
    var emailSub = ""
    var emailMess = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnSend.setOnClickListener(View.OnClickListener { kirim() })
    }

    fun kirim(){
        emailAdd = binding.etEmailAddress.text.toString()
        emailSub = binding.etSubject.text.toString()
        emailMess =binding.etMessage.text.toString()

        var emails = emailAdd.split(" ").toTypedArray()

        intent = Intent(ACTION_SEND)
        intent.putExtra(EXTRA_EMAIL,emails)
        intent.putExtra(EXTRA_SUBJECT,emailSub)
        intent.putExtra(EXTRA_TEXT,emailMess)

        intent.setType("message/rfc822")
        startActivity(Intent.createChooser(intent,"Pilih Aplikasi"))
    }
}
