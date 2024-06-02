package pnm.ac.id.apoplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import android.widget.ArrayAdapter

class HasilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        // Menerima data pesanan dari Intent
        val pesananBundle = intent.getBundleExtra("pesananBundle")

        // Menampilkan nama-nama obat yang dipesan
        pesananBundle?.let {
            val pesananList = it.getSerializable("pesananList") as Array<Obat>

            val listView = findViewById<ListView>(R.id.listView)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pesananList.map { "${it.obatName} - ${it.harga} - ${it.qty}" })
            listView.adapter = adapter
        }
    }
}