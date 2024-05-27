package pnm.ac.id.apoplus

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MenuUtamaAcitvity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_utama)

        val btnToggle1: Button = findViewById(R.id.btn_Toggle1)
        btnToggle1.setOnClickListener(this)
    }  // Ini menutup metode onCreate

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_Toggle1 -> {
                    val pindahIntent = Intent(this, DaftarObatActivity::class.java)
                    startActivity(pindahIntent)
                }
            }
        }
    }
}
