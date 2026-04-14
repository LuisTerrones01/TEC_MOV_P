package com.mgc.usopreferencias

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
class AppPreferenciasFragment : PreferenceFragmentCompat(),
    PreferenceFragmentCompat.OnPreferenceStartScreenCallback {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.misapppreferencias, rootKey)
    }

    override fun onPreferenceStartScreen(
        caller: PreferenceFragmentCompat,
        pref: androidx.preference.PreferenceScreen
    ): Boolean {
        val fragment = AppPreferenciasFragment()
        val args = Bundle()
        args.putString(ARG_PREFERENCE_ROOT, pref.key)
        fragment.arguments = args

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()

        return true
    }
}
