package id.ac.usk.shape

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tabung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabung)

        val imageButton: ImageButton = findViewById(R.id.backBtn)
        imageButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val rumus: ImageButton = findViewById(R.id.infoBtn)
        rumus.setOnClickListener {
            val intent = Intent(this, RumusTabung::class.java)
            startActivity(intent)
        }

        val inputJariJari = findViewById<EditText>(R.id.inputJariJari)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)
        val hasilVolume = findViewById<TextView>(R.id.hasilVolume)

        buttonHitung.setOnClickListener {
            val jariJari = inputJariJari.text.toString()
            val tinggi = inputTinggi.text.toString()

            if (jariJari.isEmpty() || tinggi.isEmpty()) {
                Toast.makeText(this, "Masukkan nilai jari-jari dan tinggi!", Toast.LENGTH_SHORT).show()
            } else if (!jariJari.matches(Regex("^[0-9]*\\.?[0-9]+\$")) || !tinggi.matches(Regex("^[0-9]*\\.?[0-9]+\$"))) {
                Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show()
            } else {
                val r = jariJari.toDouble()
                val t = tinggi.toDouble()
                val volume = Math.PI * r * r * t // Menggunakan rumus π × r² × t
                hasilVolume.text = "Volume: %.2f cm³".format(volume)
            }
        }

        inputJariJari.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                buttonHitung.performClick()
                return@setOnKeyListener true
            }
            false
        }

        inputTinggi.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                buttonHitung.performClick()
                return@setOnKeyListener true
            }
            false
        }

        //Tab bar
        val tabhome: ImageButton = findViewById(R.id.tab_home)
        tabhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val tabflateshape: ImageButton = findViewById(R.id.tab_flateshape)
        tabflateshape.setOnClickListener {
            val intent = Intent(this, BangunDatar::class.java)
            startActivity(intent)
        }

        val tabsolidshape: ImageButton = findViewById(R.id.tab_solidshape)
        tabsolidshape.setOnClickListener {
            val intent = Intent(this, BangunRuang::class.java)
            startActivity(intent)
        }

        val tabcalculate: ImageButton = findViewById(R.id.tab_calculate)
        tabcalculate.setOnClickListener {
            val intent = Intent(this, Kalkulator::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
