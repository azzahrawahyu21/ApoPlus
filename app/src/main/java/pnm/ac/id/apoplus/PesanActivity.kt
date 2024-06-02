import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.content.Intent
import pnm.ac.id.apoplus.R
import pnm.ac.id.apoplus.MainActivity
import pnm.ac.id.apoplus.HasilActivity
import pnm.ac.id.apoplus.Obat


class PesanActivity : ComponentActivity() {
    private var totalPesanan: Int = 0
    private val pesananList = ArrayList<String>() // Deklarasi ArrayList untuk menyimpan nama obat yang dipesan

    // Harga obat
    private val hargaDexteem = 27000
    private val hargaPonstan = 286503
    private val hargaClinovir = 37574
    private val hargaIlliadin = 79000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        // Mengambil harga dari TextView
        val hargaDexteemTextView = findViewById<TextView>(R.id.hargaDexteem)
        val hargaPonstanTextView = findViewById<TextView>(R.id.hargaPonstan)
        val hargaClinovirTextView = findViewById<TextView>(R.id.hargaClinovir)
        val hargaIlliadinTextView = findViewById<TextView>(R.id.hargaIlliadin)

        // Mengekstrak harga dari TextView dan memasukkannya ke dalam variabel
        val hargaDexteem = hargaDexteemTextView.text.toString().substringAfter("Rp.").replace(".", "").toInt()
        val hargaPonstan = hargaPonstanTextView.text.toString().substringAfter("Rp.").replace(".", "").toInt()
        val hargaClinovir = hargaClinovirTextView.text.toString().substringAfter("Rp.").replace(".", "").toInt()
        val hargaIlliadin = hargaIlliadinTextView.text.toString().substringAfter("Rp.").replace(".", "").toInt()

        setupIncrementDecrementListeners()
    }


    private fun setupIncrementDecrementListeners() {
        // Dexteem
        setupIncrementDecrement(findViewById(R.id.imageViewPlusDexteem), findViewById(R.id.imageViewMinDexteem), findViewById(R.id.textViewDexteemQty), "Dexteem plus box 100")

        // Ponstan
        setupIncrementDecrement(findViewById(R.id.imageViewPlusPonstan), findViewById(R.id.imageViewMinPonstan), findViewById(R.id.textViewPonstanQty), "Ponstan 500mg box 100")

        // Clinovir
        setupIncrementDecrement(findViewById(R.id.imageViewPlusClinovir), findViewById(R.id.imageViewMinClinovir), findViewById(R.id.textViewClinovirQty), "Clinovir Cream 5gr")

        // Illiadin
        setupIncrementDecrement(findViewById(R.id.imageViewPlusIlliadin), findViewById(R.id.imageViewMinIlliadin), findViewById(R.id.textViewIlliadinQty), "Illiadin Nasal Spray")
    }

    private fun setupIncrementDecrement(plus: ImageView, minus: ImageView, qtyTextView: TextView, obatName: String) {
        plus.setOnClickListener {
            val currentQty = qtyTextView.text.toString().toInt()
            val newQty = currentQty + 1
            qtyTextView.text = newQty.toString()
            totalPesanan++
            updateQtyColor(qtyTextView, newQty)
            updateTotalPesananTextView()
            pesananList.add(obatName) // Menambahkan nama obat ke dalam pesananList saat ditambahkan ke keranjang
        }

        minus.setOnClickListener {
            val currentQty = qtyTextView.text.toString().toInt()
            if (currentQty > 0) {
                val newQty = currentQty - 1
                qtyTextView.text = newQty.toString()
                totalPesanan--
                updateQtyColor(qtyTextView, newQty)
                updateTotalPesananTextView()
                pesananList.remove(obatName) // Menghapus nama obat dari pesananList saat dihapus dari keranjang
            }
        }
    }

    fun onItemClicked(view: View) {
        val qtyTextView = view.findViewById<TextView>(R.id.textViewDexteemQty)
        val currentQty = qtyTextView.text.toString().toInt()
        if (currentQty > 0) {
            totalPesanan -= currentQty
            qtyTextView.text = "0"
            updateQtyColor(qtyTextView, 0)
            updateTotalPesananTextView()
            pesananList.remove("Dexteem plus box 100") // Menghapus nama obat dari pesananList saat diklik
        } else {
            qtyTextView.text = "1"
            totalPesanan++
            updateQtyColor(qtyTextView, 1)
            updateTotalPesananTextView()
            pesananList.add("Dexteem plus box 100") // Menambahkan nama obat ke dalam pesananList saat diklik
        }
    }

    private fun updateQtyColor(qtyTextView: TextView, qty: Int) {
        if (qty > 0) {
            qtyTextView.setTextColor(getColor(R.color.orange))
        } else {
            qtyTextView.setTextColor(getColor(R.color.grey))
        }
    }

    private fun updateTotalPesananTextView() {
        val totalPesananTextView = findViewById<TextView>(R.id.textView3)
        totalPesananTextView.text = "Jumlah Pesananan : $totalPesanan"
    }

    fun onCancelClicked(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onNextClicked(view: View) {
        val intent = Intent(this, HasilActivity::class.java)
        val bundle = Bundle()

        // Menyiapkan data pesanan
        val pesananList = ArrayList<Obat>()

        // Mendapatkan nilai dari TextView
        val qtyDexteem = findViewById<TextView>(R.id.textViewDexteemQty).text.toString().toInt()
        val qtyPonstan = findViewById<TextView>(R.id.textViewPonstanQty).text.toString().toInt()
        val qtyClinovir = findViewById<TextView>(R.id.textViewClinovirQty).text.toString().toInt()
        val qtyIlliadin = findViewById<TextView>(R.id.textViewIlliadinQty).text.toString().toInt()


        // Menambahkan pesanan ke dalam list
        pesananList.add(Pair("Dexteem plus box 100", hargaDexteem, qtyDexteem))
        pesananList.add(Pair("Ponstan 500mg box 100", hargaPonstan, qtyPonstan))
        pesananList.add(Pair("Clinovir Cream 5gr", hargaClinovir, qtyClinovir))
        pesananList.add(Pair("Illiadin Nasal Spray", hargaIlliadin, qtyIlliadin))

        // Menyimpan data pesanan dalam bundle
        bundle.putSerializable("pesananList", pesananList.toTypedArray())

        // Mengirim data pesanan ke HasilActivity
        intent.putExtra("pesananBundle", bundle)
        startActivity(intent)
    }


}
