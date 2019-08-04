package com.github.jeremyrempel.yaba.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.jeremyrempel.yaba.android.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // init dagger graph
//        val dagger: AppComponent = DaggerAppComponent.create()

//        supportFragmentManager.fragmentFactory = dagger.fragFactory()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, buildContentsListFragment())
                .commitNow()
        }
    }

    private fun buildContentsListFragment(): Fragment {
//        return supportFragmentManager
//            .fragmentFactory
//            .instantiate(classLoader, ContentsListFragment::class.java.canonicalName)

        return MainListFragment()
    }
}