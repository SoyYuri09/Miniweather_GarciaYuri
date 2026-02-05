package garcia.yuri.miniweather_apellidoy

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvGreetingAgain = findViewById<TextView>(R.id.tvGreetingAgain)
        val ivSegundaActivity = findViewById<ImageView>(R.id.ivSegundaActivity)
        val tvTextoAnterior = findViewById<TextView>(R.id.tvTextoAnterior)

        tvGreetingAgain.setText("Segunda Activity!!")
        ivSegundaActivity.setImageResource(R.drawable.icono)

        //Recibir los datos de la MainActivity
        val dato01 = intent.getStringExtra("dato01")

        //Setear el texto obtenido de la activity anterior a la nueva
        tvTextoAnterior.setText(dato01)

    }
}