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

class Balok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_balok)

        val imageButton: ImageButton = findViewById(R.id.backBtn)
        imageButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val rumus: ImageButton = findViewById(R.id.infoBtn)
        rumus.setOnClickListener {
            val intent = Intent(this, RumusBalok::class.java)
            startActivity(intent)
        }

        val inputPanjang = findViewById<EditText>(R.id.inputpanjang)
        val inputLebar = findViewById<EditText>(R.id.inputlebar)
        val inputTinggi = findViewById<EditText>(R.id.inputtinggi)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)
        val hasilVolume = findViewById<TextView>(R.id.hasilVolume)

        buttonHitung.setOnClickListener {
            val panjang = inputPanjang.text.toString()
            val lebar = inputLebar.text.toString()
            val tinggi = inputTinggi.text.toString()

            if (panjang.isEmpty() || lebar.isEmpty() || tinggi.isEmpty()) {
                Toast.makeText(this, "Masukkan nilai panjang, lebar, dan tinggi!", Toast.LENGTH_SHORT).show()
            } else if (!panjang.all { it.isDigit() } || !lebar.all { it.isDigit() } || !tinggi.all { it.isDigit() }) {
                Toast.makeText(this, "Hanya angka yang diperbolehkan!", Toast.LENGTH_SHORT).show()
            } else {
                val p = panjang.toDouble()
                val l = lebar.toDouble()
                val t = tinggi.toDouble()
                val volume = p * l * t
                hasilVolume.text = "Volume: %.0f cm³".format(volume)
            }
        }

        inputPanjang.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                buttonHitung.performClick()
                return@setOnKeyListener true
            }
            false
        }

        inputLebar.setOnKeyListener { v, keyCode, event ->
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