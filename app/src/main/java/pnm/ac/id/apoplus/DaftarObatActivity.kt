package pnm.ac.id.apoplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View


class DaftarObatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_obat)
    }
    fun onBackButtonClicked(view: View) {
        finish() // Kembali ke activity sebelumnya
    }
}
