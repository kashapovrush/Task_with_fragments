package com.kashapovrush.taskwithfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kashapovrush.taskwithfragments.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transitionToC.setOnClickListener {
            (requireActivity() as OnClickListenerFromFragmentB).onClickListenerFromFragmentB()
        }

        binding.back.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    interface OnClickListenerFromFragmentB {
        fun onClickListenerFromFragmentB()
    }

    companion object {

        fun newInstance() = FragmentB()
    }
}