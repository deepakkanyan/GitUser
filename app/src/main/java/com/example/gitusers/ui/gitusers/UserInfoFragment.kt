package com.example.gitusers.ui.gitusers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.gitusers.databinding.FragmentUserInfoBinding
import com.example.gitusers.presenter.GitUserInfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!
    val args: UserInfoFragmentArgs by navArgs()
    private val viewModel: GitUserInfoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gitUser = args.user
        subscribeUI()
    }

    private fun subscribeUI() {

        viewModel.visitProfile.observe(viewLifecycleOwner){
            val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(args.user?.followersUrl))
            startActivity(myIntent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}