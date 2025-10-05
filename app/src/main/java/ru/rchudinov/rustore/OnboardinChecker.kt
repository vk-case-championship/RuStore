package ru.rchudinov.rustore

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class OnboardinChecker {
    fun saveFirstLaunch(context: Context, isFirstLaunch: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        sharedPreferences.edit {
            putBoolean("isFirstLaunch", isFirstLaunch)
        }
    }

    fun isFirstLaunch(context: Context): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isFirstLaunch", true)
    }


}