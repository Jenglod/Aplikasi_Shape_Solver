package id.ac.usk.shape

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BangunRuang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bangun_ruang)

        val imageButton: ImageButton = findViewById(R.id.backBtn)
        imageButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val icontabung: ImageButton = findViewById(R.id.tabung)
        icontabung.setOnClickListener {
            val intent = Intent(this, Tabung::class.java)
            startActivity(intent)
        }

        val iconkerucut: ImageButton = findViewById(R.id.kerucut)
        iconkerucut.setOnClickListener {
            val intent = Intent(this, Kerucut::class.java)
            startActivity(intent)
        }

        val iconkubus: ImageButton = findViewById(R.id.kubus)
        iconkubus.setOnClickListener {
            val intent = Intent(this, Kubus::class.java)
            startActivity(intent)
        }

        val iconbalok: ImageButton = findViewById(R.id.balok)
        iconbalok.setOnClickListener {
            val intent = Intent(this, Balok::class.java)
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