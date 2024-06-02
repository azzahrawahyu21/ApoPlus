package pnm.ac.id.apoplus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnm.ac.id.apoplus.ui.theme.ApoPlusTheme

class MainActivity : ComponentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToggle1: ToggleButton = findViewById(R.id.btn_Toggle1)
        val btnToggle2: ToggleButton = findViewById(R.id.btn_Toggle2)

        btnToggle1.setOnClickListener(this)
        btnToggle2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_Toggle1 -> {
                val pindahIntent = Intent(this, DaftarObatActivity::class.java)
                startActivity(pindahIntent)
            }
            R.id.btn_Toggle2 -> {
                val pindahIntent = Intent(this, PesanActivity::class.java)
                startActivity(pindahIntent)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApoPlusTheme {
        Greeting("Android")
    }
}
