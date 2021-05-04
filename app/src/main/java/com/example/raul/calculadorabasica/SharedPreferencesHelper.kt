package com.example.raul.calculadorabasica

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPreferencesHelper {
    val prefsName = "DefaultPrefs"

    fun saveText(context: Context, key: String, value: String) {
        var sharedPreferences = context.getSharedPreferences(prefsName, 0)
        var editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getText(context: Context, key: String):String {
        var sharedPreferences = context.getSharedPreferences(prefsName, 0)
        return sharedPreferences.getString(key, "")
    }

    fun clean(context: Context) {
        var sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().commit()
    }
}