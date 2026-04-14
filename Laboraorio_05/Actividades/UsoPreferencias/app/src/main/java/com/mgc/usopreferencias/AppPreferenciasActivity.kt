package com.mgc.usopreferencias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.mgc.usopreferencias.AppPreferenciasFragment

class AppPreferenciasActivity : AppCompatActivity(),
    PreferenceFragmentCompat.OnPreferenceStartScreenCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AppPreferenciasFragment())
            .commit()
    }

    override fun onPreferenceStartScreen(
        caller: PreferenceFragmentCompat,
        pref: androidx.preference.PreferenceScreen
    ): Boolean {
        val fragment = AppPreferenciasFragment()
        val args = Bundle()
        args.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, pref.key)
        fragment.arguments = args

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()

        return true
    }
}