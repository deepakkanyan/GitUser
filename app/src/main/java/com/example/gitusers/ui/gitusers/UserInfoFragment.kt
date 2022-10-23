package com.example.gitusers.ui.gitusers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.gitusers.databinding.FragmentUserInfoBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class UserInfoFragment : Fragment() {

    private var _binding:  FragmentUserInfoBinding? = null
    private val binding get() = _binding!!
    val args: UserInfoFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gitUser = args.userID
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}