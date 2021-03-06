package com.bennyhuo.tieguanyin.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bennyhuo.tieguanyin.annotations.ActivityBuilder
import com.bennyhuo.tieguanyin.sample.fragments.showKotlinFragment

/**
 * Created by benny on 1/29/18.
 */
@ActivityBuilder
class FragmentContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        title = this.javaClass.simpleName

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null)
            showKotlinFragment(R.id.fragmentContainer, "Kotlin Fragment")
    }
}
