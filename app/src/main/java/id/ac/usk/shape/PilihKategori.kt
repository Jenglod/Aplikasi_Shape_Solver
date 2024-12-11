package id.ac.usk.shape

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PilihKategori : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pilih_kategori)

        val imageButton: ImageButton = findViewById(R.id.backBtn)
        imageButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val imageBangundatar: ImageButton = findViewById (R.id.imageButton1)
        imageBangundatar.setOnClickListener {
            val intent = Intent(this, BangunDatar::class.java)
            startActivity(intent)
        }

        val imageBangunruang: ImageButton = findViewById(R.id.imageButton2)
        imageBangunruang.setOnClickListener {
            val intent = Intent(this, BangunRuang::class.java)
            startActivity(intent)
        }

        val imageButtonCalculator: ImageButton = findViewById(R.id.imageButton3)
        imageButtonCalculator.setOnClickListener {
            val intent = Intent(this, Kalkulator::class.java)
            startActivity(intent)
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