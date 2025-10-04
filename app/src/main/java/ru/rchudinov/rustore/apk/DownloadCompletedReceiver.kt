package ru.rchudinov.rustore.apk

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

class DownloadCompletedReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.intent.action.DOWNLOAD_COMPLETE") {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
            if (id != -1L) {
                println("Download with ID $id finished!")
            }
        }
    }

    private fun installApk(context: Context?, apkUri: Uri) {
        val file = File(apkUri.path) // Получаем файл
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        // Используем FileProvider для указания APK-файла (если его нужно передать)
        val fileProviderUri = FileProvider.getUriForFile(context!!, "${context.packageName}.fileprovider", file)
        intent.setDataAndType(fileProviderUri, "application/vnd.android.package-archive")

        context.startActivity(intent)
    }
}