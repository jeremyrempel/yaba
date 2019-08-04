package com.github.jeremyrempel.yaba.android.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.jeremyrempel.yaba.android.photolist.ui.PhotoListFragment
import javax.inject.Inject
import javax.inject.Provider

class FragFactory @Inject constructor(
    private val listFragProvider: Provider<PhotoListFragment>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            PhotoListFragment::class.java.canonicalName -> listFragProvider.get()
            else -> TODO("Missing fragment $className")
        }
    }
}