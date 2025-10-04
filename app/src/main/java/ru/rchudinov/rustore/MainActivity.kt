package ru.rchudinov.rustore

import android.os.Bundle
import android.telecom.Call
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.rchudinov.rustore.retrofit.ProductApi


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val productApi = retrofit.create(ProductApi::class.java)

        val tv = findViewById<TextView>(R.id.textView)
        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val product = productApi.getProductsById()
                runOnUiThread {
                    tv.text = product.title
                }
            }
        }



        //enableEdgeToEdge()
    }
}