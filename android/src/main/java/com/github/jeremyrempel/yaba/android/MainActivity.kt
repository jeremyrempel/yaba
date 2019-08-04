package com.github.jeremyrempel.yaba.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.jeremyrempel.yaba.android.photolist.ui.PhotoListFragment
import com.github.jeremyrempel.yaba.di.AppComponent
import com.github.jeremyrempel.yaba.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // init dagger graph
        val dagger: AppComponent = DaggerAppComponent.create()

        supportFragmentManager.fragmentFactory = dagger.fragFactory()

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
        return supportFragmentManager
            .fragmentFactory
            .instantiate(classLoader, PhotoListFragment::class.java.canonicalName)
    }
}