package com.kashapovrush.taskwithfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kashapovrush.taskwithfragments.databinding.FragmentCBinding

class FragmentC : Fragment() {

    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transitionToD.setOnClickListener {
            (requireActivity() as OnClickListenerFromFragmentC).onClickListenerFromFragmentCToD()
        }

        binding.transitionToA.setOnClickListener {
            (requireActivity() as OnClickListenerFromFragmentC).onClickListenerFromFragmentCToA()
        }

        binding.textFromB.text = arguments?.getString(EXTRA_TEXT)
    }

    interface OnClickListenerFromFragmentC {

        fun onClickListenerFromFragmentCToD()

        fun onClickListenerFromFragmentCToA()
    }

    companion object {

        const val EXTRA_TEXT = "text"

        fun newInstance() = FragmentC().apply {
            arguments = Bundle().apply {
                putString(EXTRA_TEXT, "Hello Fragment C")
            }
        }
    }
}