package pnm.ac.id.apoplus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
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
        val tvTotalBayar = findViewById<TextView>(R.id.total_bayar_value_text_view)

        // Calculate and set total payment
        val totalBayar = dexteemTotal + ponstanTotal + clinovirTotal + iliadinTotal
        tvTotalBayar.text = "Rp.$totalBayar"

        // Find the confirmation button
        val konfirmasiButton = findViewById<Button>(R.id.konfirmasi_button)

        // Set click listener for the confirmation button
        konfirmasiButton.setOnClickListener {
            // Create an intent to navigate back to the main menu
            val intent = Intent(this, MainActivity::class.java)
            // Start the MainActivity
            startActivity(intent)
            // Finish this activity
            finish()
        }
    }
}
