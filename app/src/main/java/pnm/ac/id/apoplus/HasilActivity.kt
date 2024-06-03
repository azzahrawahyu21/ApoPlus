package pnm.ac.id.apoplus

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class HasilActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        // Retrieve quantities and prices from intent
        val dexteemQuantity = intent.getIntExtra("DEXTEEM_QUANTITY", 0)
        val ponstanQuantity = intent.getIntExtra("PONSTAN_QUANTITY", 0)
        val clinovirQuantity = intent.getIntExtra("CLINOVIR_QUANTITY", 0)
        val iliadinQuantity = intent.getIntExtra("ILIADIN_QUANTITY", 0)
        val dexteemPrice = 27000
        val ponstanPrice = 286503
        val clinovirPrice = 37574
        val iliadinPrice = 79000

        // Calculate total prices
        val dexteemTotal = dexteemQuantity * dexteemPrice
        val ponstanTotal = ponstanQuantity * ponstanPrice
        val clinovirTotal = clinovirQuantity * clinovirPrice
        val iliadinTotal = iliadinQuantity * iliadinPrice

        // Find TextViews
        val tvDexteemQuantity = findViewById<TextView>(R.id.jumlah_pesanan_value_text_view)
        val tvPonstanQuantity = findViewById<TextView>(R.id.harga_obat_value_text_view)
        val tvClinovirQuantity = findViewById<TextView>(R.id.harga_obat_value_text_view)
        val tvIliadinQuantity = findViewById<TextView>(R.id.harga_obat_value_text_view)
        val tvTotalBayar = findViewById<TextView>(R.id.total_bayar_value_text_view)

        // Set text to TextViews
        tvDexteemQuantity.text = "$dexteemQuantity"
        tvPonstanQuantity.text = "$ponstanQuantity"
        tvClinovirQuantity.text = "$clinovirQuantity"
        tvIliadinQuantity.text = "$iliadinQuantity"

        // Calculate and set total payment
        val totalBayar = dexteemTotal + ponstanTotal + clinovirTotal + iliadinTotal
        tvTotalBayar.text = "Rp.$totalBayar"
    }
}
