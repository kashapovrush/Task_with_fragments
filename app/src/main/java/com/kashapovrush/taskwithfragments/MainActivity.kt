package com.kashapovrush.taskwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.kashapovrush.taskwithfragments.FragmentA.Companion.FRAGMENT_A_TAG
import com.kashapovrush.taskwithfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentA.OnClickListenerFromFragmentA,
    FragmentB.OnClickListenerFromFragmentB, FragmentC.OnClickListenerFromFragmentC,
    FragmentD.OnCLickListenerFromFragmentD {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, FragmentA.newInstance())
                .commit()
        }
    }

    override fun onClickListenerFromFragmentA() {
        supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, FragmentB.newInstance())
            ?.addToBackStack(FRAGMENT_A_TAG)
            ?.commit()
    }

    override fun onClickListenerFromFragmentB() {
        supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, FragmentC.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun onClickListenerFromFragmentCToA() {
        supportFragmentManager?.popBackStack(
            FRAGMENT_A_TAG,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, FragmentA.newInstance())
            ?.commit()
    }

    override fun onClickListenerFromFragmentCToD() {
        supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, FragmentD.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun onClickListenerFromFragmentD() {
       supportFragmentManager?.popBackStack(FRAGMENT_A_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, FragmentB.newInstance())
            ?.commit()
    }

}