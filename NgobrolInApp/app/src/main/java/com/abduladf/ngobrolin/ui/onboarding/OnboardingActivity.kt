package com.abduladf.ngobrolin.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.abduladf.ngobrolin.MainActivity
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.ActivityOnboardingBinding
import com.abduladf.ngobrolin.ui.login.LoginRegisterActivity

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val btn = findViewById<ImageView>(R.id.btn_get_started)
        btn.setOnClickListener {
            startActivity(Intent(this, LoginRegisterActivity::class.java))
            finish()
        }
    }
}