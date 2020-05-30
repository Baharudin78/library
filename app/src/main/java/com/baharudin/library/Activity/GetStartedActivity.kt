package com.baharudin.library.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.library.R
import kotlinx.android.synthetic.main.activity_get_started.*

class GetStartedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        Bt_masuk.setOnClickListener {
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }
        Bt_daftar.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}
