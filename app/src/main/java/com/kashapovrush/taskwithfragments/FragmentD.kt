package com.kashapovrush.taskwithfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kashapovrush.taskwithfragments.databinding.FragmentDBinding

class FragmentD : Fragment() {

    private lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transitionToB.setOnClickListener {
            (requireActivity() as OnCLickListenerFromFragmentD).onClickListenerFromFragmentD()
        }
    }

    interface OnCLickListenerFromFragmentD {

        fun onClickListenerFromFragmentD()
    }

    companion object {

        fun newInstance() = FragmentD()
    }
}