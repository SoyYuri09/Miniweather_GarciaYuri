package garcia.yuri.miniweather_apellidoy

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Texto de ejemplo para enviar a la segunda activity
        val textoActivity2 = "Hola Segunda Activity"

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val tvCity = findViewById<TextView>(R.id.tvCity)
        val ivWeather = findViewById<ImageView>(R.id.ivWeather)
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val tvWeather = findViewById<TextView>(R.id.tvWeather)
        val btnCambiarActivity = findViewById<Button>(R.id.btnCambiarActivity)
        val btnCambioClima = findViewById<Button>(R.id.btnCambioClima)

        tvGreeting.setText("Bienvenid@!!!")
        tvCity.setText("Cd. Obregón")
        ivWeather.setImageResource(R.drawable.gd)
        tvTemperature.setText("30° C")
        tvWeather.setText("Nublado")

        btnCambiarActivity.setOnClickListener {
            val cambiarActivity = Intent(this, SecondActivity::class.java)
            cambiarActivity.putExtra("dato01",textoActivity2)
            startActivity(cambiarActivity)
        }

    }

}