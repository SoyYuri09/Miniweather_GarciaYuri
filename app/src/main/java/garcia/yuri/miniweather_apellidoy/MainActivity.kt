package garcia.yuri.miniweather_apellidoy

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        tvWeather.setText("Clima...")

        btnCambiarActivity.setOnClickListener {
            val cambiarActivity = Intent(this, SecondActivity::class.java)
            cambiarActivity.putExtra("dato01",textoActivity2)
            startActivity(cambiarActivity)
        }

        btnCambioClima.setOnClickListener {
            cambiarClima(tvWeather, ivWeather)
        }

    }

    fun cambiarClima(tvWeather: TextView, ivWeather: ImageView){
        val climas = listOf<String>("Soleado", "Nublado", "Lluviozo", "Nieve", "Tormentas", "Ventoso")
        val clima = climas.random()

        tvWeather.text = clima
        when(clima){
            "Soleado" -> ivWeather.setImageResource(R.drawable.ic_sunny)
            "Nublado" -> ivWeather.setImageResource(R.drawable.ic_cloudy)
            "Lluvioso" -> ivWeather.setImageResource(R.drawable.ic_rainy)
            "Nieve" -> ivWeather.setImageResource(R.drawable.ic_snowy)
            "Tormentas" -> ivWeather.setImageResource(R.drawable.ic_stormy)
            "Ventoso" -> ivWeather.setImageResource(R.drawable.ic_windy)
        }

    }

}