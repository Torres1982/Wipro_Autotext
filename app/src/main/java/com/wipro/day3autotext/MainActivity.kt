package com.wipro.day3autotext

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textViewWebLink: TextView
    private lateinit var textViewPhone: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var textViewLocation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewWebLink = findViewById(R.id.text_view_web_link)
        textViewPhone = findViewById(R.id.text_view_phone)
        textViewEmail = findViewById(R.id.text_view_email)
        textViewLocation = findViewById(R.id.text_view_location)

        textViewWebLink.setOnClickListener {
            val url = resources.getString(R.string.web_link)
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        textViewPhone.setOnClickListener {
            val phone = resources.getString(R.string.phone)
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
        }

        textViewEmail.setOnClickListener {
            val email = resources.getString(R.string.email)
            val emailSubject = "Testing Email Intent"
            val emailBody = "Body of the Testing email"
            val emailBuilder = "mailto:$email?subject=$emailSubject&body=$emailBody"
            val uri = Uri.parse(emailBuilder)
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = uri
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        textViewLocation.setOnClickListener {
            val locationUri = Uri.parse("geo:53.3498,-6.2603")
            val showLocation = Intent(Intent.ACTION_VIEW, locationUri)
            showLocation.`package` = "com.google.android.apps.maps"

            if (showLocation.resolveActivity(packageManager) != null) startActivity(showLocation)
        }
    }
}
