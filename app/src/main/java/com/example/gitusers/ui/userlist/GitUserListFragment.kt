package com.example.gitusers.ui.userlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitusers.R
import com.example.gitusers.databinding.FragmentGitUserListBinding
import com.example.gitusers.presenter.GitUserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GitUserListFragment : Fragment() {
    private val usersListViewModel: GitUserListViewModel by viewModel()
    private var _binding: FragmentGitUserListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGitUserListBinding.inflate(inflater, container, false)
        val recyclerViewNews = binding.guRecycleview
        usersListViewModel.gitUserList.observe(viewLifecycleOwner) { userList ->
            recyclerViewNews.adapter = userList?.items?.let { it1 -> GitUserAdapter(it1){
               val action = GitUserListFragmentDirections.actionFirstFragmentToSecondFragment(it)
               findNavController().navigate(action)

            } }
            recyclerViewNews.layoutManager = LinearLayoutManager(requireActivity())
        }
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}