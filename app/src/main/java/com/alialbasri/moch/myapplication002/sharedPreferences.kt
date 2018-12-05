package com.alialbasri.moch.myapplication002

import android.content.Context
import android.preference.PreferenceManager
import android.text.TextUtils



class sharedPreferences {



    enum class types {
        Strings, Integers, Floats, Booleans
    }

    private fun PreferenceHelper(){}


    fun getAnyPreference(context: Context, key: String, keyType: types): Any? {
        var value: Any? = null


        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            when (keyType){
                types.Strings -> value = preferences.getString(key, "")
                types.Integers -> value = preferences.getInt(key, 0)
                types.Booleans -> value = preferences.getBoolean(key, false)
                types.Floats -> value = preferences.getFloat(key, 0f)

            }

        }
        return value
    }


    fun setAnyPreference(context: Context, key: String, value: Any, keyType: types): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            when (keyType){
                types.Strings -> editor.putString(key, value.toString())
                types.Integers -> editor.putInt(key, value.toString().toInt())
                types.Booleans -> editor.putBoolean(key, value.toString().toBoolean())
                types.Floats -> editor.putFloat(key, value.toString().toFloat())

            }
            editor.apply()
            return true
        }
        return false
    }



    // String
    fun getStringPreference(context: Context, key: String): String? {
        var value: String? = null
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            value = preferences.getString(key, null)
        }
        return value
    }


    fun setStringPreference(context: Context, key: String, value: String): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            editor.putString(key, value)
            editor.apply()
            return true        }
        return false
    }




    // Float
    fun getFloatPreference(context: Context, key: String, defaultValue: Float): Float {
        var value = defaultValue
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            value = preferences.getFloat(key, defaultValue)
        }
        return value
    }

    fun setFloatPreference(context: Context, key: String, value: Float): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putFloat(key, value)
            editor.apply()
            return true
        }
        return false
    }




    // Long
    fun getLongPreference(context: Context, key: String, defaultValue: Long): Long {
        var value = defaultValue
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            value = preferences.getLong(key, defaultValue)
        }
        return value
    }


    fun setLongPreference(context: Context, key: String, value: Long): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putLong(key, value)
            editor.apply()
            return true
        }
        return false
    }




    //Integer
    fun getIntegerPreference(context: Context, key: String, defaultValue: Int): Int {
        var value = defaultValue
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            value = preferences.getInt(key, defaultValue)
        }
        return value
    }


    fun setIntegerPreference(context: Context, key: String, value: Int): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putInt(key, value)
            editor.apply()
            return true
        }
        return false
    }





    // Boolean
    fun getBooleanPreference(context: Context, key: String, defaultValue: Boolean): Boolean {
        var value = defaultValue
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            value = preferences.getBoolean(key, defaultValue)
        }
        return value
    }


    fun setBooleanPreference(context: Context, key: String, value: Boolean): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putBoolean(key, value)
            editor.apply()
            return true
        }
        return false
    }
}