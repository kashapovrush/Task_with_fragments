package com.kashapovrush.taskwithfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kashapovrush.taskwithfragments.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.transitionToB.setOnClickListener {
            (requireActivity() as OnClickListenerFromFragmentA).onClickListenerFromFragmentA()
        }
    }

    interface OnClickListenerFromFragmentA {
        fun onClickListenerFromFragmentA()
    }

    companion object {
        const val FRAGMENT_A_TAG = "fragment_a_tag"

        fun newInstance() = FragmentA()
    }
}