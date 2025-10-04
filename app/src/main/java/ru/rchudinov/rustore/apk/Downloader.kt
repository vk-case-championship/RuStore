package ru.rchudinov.rustore.apk

interface Downloader {
    fun downloadFile(url: String): Long
}