package com.curymorais.gittopreposbycury

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.curymorais.gittopreposbycury.topgitrepos.TopGitReposFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout_constraint)

        initComponents()
        setComponentListeners()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            TopGitReposFragment()
        ).commit()
    }

    fun initComponents(){

    }

    fun setComponentListeners(){

    }

//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
//        return false
//    }
//
//    private fun loadFragment(fragment : Fragment?) : Boolean{
//        if (fragment != null){
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit()
//            return  true
//        }
//        return false
//    }


}