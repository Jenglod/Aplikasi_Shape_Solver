package id.ac.usk.shape

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class Kalkulator : AppCompatActivity() {
    private lateinit var inputTextView: TextView
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        val imageButton: ImageButton = findViewById(R.id.backBtn)
        imageButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        inputTextView = findViewById(R.id.input)
        outputTextView = findViewById(R.id.output)

        val buttonIds = listOf(
            R.id.button_0 to "0", R.id.button_1 to "1", R.id.button_2 to "2", R.id.button_3 to "3",
            R.id.button_4 to "4", R.id.button_5 to "5", R.id.button_6 to "6", R.id.button_7 to "7",
            R.id.button_8 to "8", R.id.button_9 to "9",
            R.id.button_addition to "+", R.id.button_subtraction to "-",
            R.id.button_multiply to "*", R.id.button_division to "/",
            R.id.button_dot to ".", R.id.button_bracket to "(", R.id.button_bracket_r to ")"
        )

        buttonIds.forEach { (id, value) ->
            findViewById<Button>(id).setOnClickListener { appendInput(value) }
        }

        findViewById<Button>(R.id.button_clear).setOnClickListener {
            val currentInput = inputTextView.text.toString()
            if (currentInput.isNotEmpty()) {
                inputTextView.text = currentInput.dropLast(1)
            }
            outputTextView.text = ""
        }

        findViewById<Button>(R.id.button_croxx).setOnClickListener {
            inputTextView.text = ""
            outputTextView.text = ""
        }

        findViewById<Button>(R.id.button_equals).setOnClickListener { calculateResult() }
    }

    private fun appendInput(value: String) {
        inputTextView.append(value)
    }

    private fun calculateResult() {
        val input = inputTextView.text.toString()
        try {
            val expression = ExpressionBuilder(input).build()
            val result = expression.evaluate()
            outputTextView.text = result.toString()
        } catch (e: Exception) {
            Toast.makeText(this, "Kesalahan dalam perhitungan", Toast.LENGTH_SHORT).show()
        }
    }


}
