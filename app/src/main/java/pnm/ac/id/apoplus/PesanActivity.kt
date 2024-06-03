package pnm.ac.id.apoplus

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.content.Intent
import android.graphics.Color

class PesanActivity : ComponentActivity() {

    private lateinit var totalPesananTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        totalPesananTextView = findViewById(R.id.textView3)
        setupIncrementDecrementListeners()
    }

    private fun setupIncrementDecrementListeners() {
        // Dexteem
        setupIncrementDecrement(
            findViewById(R.id.imageViewPlusDexteem),
            findViewById(R.id.imageViewMinDexteem),
            findViewById(R.id.textViewDexteemQty)
        )

        // Ponstan
        setupIncrementDecrement(
            findViewById(R.id.imageViewPlusPonstan),
            findViewById(R.id.imageViewMinPonstan),
            findViewById(R.id.textViewPonstanQty)
        )

        // Clinovir
        setupIncrementDecrement(
            findViewById(R.id.imageViewPlusClinovir),
            findViewById(R.id.imageViewMinClinovir),
            findViewById(R.id.textViewClinovirQty)
        )

        // Illiadin
        setupIncrementDecrement(
            findViewById(R.id.imageViewPlusIlliadin),
            findViewById(R.id.imageViewMinIlliadin),
            findViewById(R.id.textViewIlliadinQty)
        )
    }

    private fun setupIncrementDecrement(plus: ImageView, minus: ImageView, qtyTextView: TextView) {
        plus.setOnClickListener {
            val currentQty = qtyTextView.text.toString().toInt()
            val newQty = currentQty + 1
            qtyTextView.text = newQty.toString()
            updateQtyColor(qtyTextView, newQty)
            updateTotalPesananTextView()
        }

        minus.setOnClickListener {
            val currentQty = qtyTextView.text.toString().toInt()
            if (currentQty > 0) {
                val newQty = currentQty - 1
                qtyTextView.text = newQty.toString()
                updateQtyColor(qtyTextView, newQty)
                updateTotalPesananTextView()
            }
        }
    }

    private fun updateQtyColor(qtyTextView: TextView, qty: Int) {
        if (qty > 0) {
            qtyTextView.setTextColor(Color.parseColor("#FFA500")) // Orange color
        } else {
            qtyTextView.setTextColor(Color.DKGRAY) // Default darker gray color
        }
    }

    private fun updateTotalPesananTextView() {
        val qtyDexteem = findViewById<TextView>(R.id.textViewDexteemQty).text.toString().toInt()
        val qtyPonstan = findViewById<TextView>(R.id.textViewPonstanQty).text.toString().toInt()
        val qtyClinovir = findViewById<TextView>(R.id.textViewClinovirQty).text.toString().toInt()
        val qtyIlliadin = findViewById<TextView>(R.id.textViewIlliadinQty).text.toString().toInt()

        val totalPesanan = qtyDexteem + qtyPonstan + qtyClinovir + qtyIlliadin
        totalPesananTextView.text = "Jumlah Pesanan: $totalPesanan"
    }

    fun onCancelClicked(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onNextClicked(view: View) {
        val intent = Intent(this, HasilActivity::class.java).apply {
            putExtra("DEXTEEM_QUANTITY", findViewById<TextView>(R.id.textViewDexteemQty).text.toString().toInt())
            putExtra("PONSTAN_QUANTITY", findViewById<TextView>(R.id.textViewPonstanQty).text.toString().toInt())
            putExtra("CLINOVIR_QUANTITY", findViewById<TextView>(R.id.textViewClinovirQty).text.toString().toInt())
            putExtra("ILIADIN_QUANTITY", findViewById<TextView>(R.id.textViewIlliadinQty).text.toString().toInt())
        }
        startActivity(intent)
    }
}
