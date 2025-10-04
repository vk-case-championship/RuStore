package ru.rchudinov.rustore

import android.app.DownloadManager
import android.os.Bundle
import android.telecom.Call
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.rchudinov.rustore.apk.AndroidDownloader
import ru.rchudinov.rustore.retrofit.ProductApi


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val downloader = AndroidDownloader(this)
        //downloader.downloadFile("https://d-09.winudf.com/custom/com.apkpure.aegon-3205327.apk?_fn=QVBLUHVyZV92My4yMC41M19hcGtwdXJlLmNvbS5hcGs&_p=Y29tLmFwa3B1cmUuYWVnb24&am=cLwN6WCL35Yoszdx1rSMVA&arg=apkpure%3A%2F%2Fcampaign%2F%3Freport_context%3D%7B%22channel_id%22%3A2010%7D&at=1759578432&download_id=1618301151570383&k=1cade77f8f4b736b0c07cbdbbc2969fc68e25ac4&r=https%3A%2F%2Fwww.google.com%2F&uu=http%3A%2F%2F172.16.52.1%2Fcustom%2Fcom.apkpure.aegon-3205327.apk%3Fk%3D04021ae83bf105989cd69f263d8f36b468e25ac4")
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://dummyjson.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val productApi = retrofit.create(ProductApi::class.java)
//
//
//        val tv = findViewById<TextView>(R.id.textView)
//        val b = findViewById<Button>(R.id.button)
//        b.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                val product = productApi.getProductsById()
//                runOnUiThread {
//                    tv.text = product.title
//                }
//            }
//        }




        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
    }
}