package id.ac.usk.shape

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val BtnMulai: ImageButton = findViewById(R.id.buttonmulai)
        BtnMulai.setOnClickListener {
            val intent = Intent(this, PilihKategori::class.java)
            startActivity(intent)
        }

        val iconbalok: ImageButton = findViewById(R.id.icon_balok)
        iconbalok.setOnClickListener {
            val intent = Intent(this, Balok::class.java)
            startActivity(intent)
        }

        val iconpersegi: ImageButton = findViewById(R.id.icon_persegi)
        iconpersegi.setOnClickListener {
            val intent = Intent(this, Persegi::class.java)
            startActivity(intent)
        }

        val iconlingkaran: ImageButton = findViewById(R.id.icon_lingkaran)
        iconlingkaran.setOnClickListener {
            val intent = Intent(this, Lingkaran::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}