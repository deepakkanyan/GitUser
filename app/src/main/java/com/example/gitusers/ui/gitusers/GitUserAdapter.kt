package com.example.gitusers.ui.gitusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitusers.data.model.GitUserInfo
import com.example.gitusers.databinding.ItemGitUserBinding

class GitUserAdapter(private val gitUserList: List<GitUserInfo>,val onUserSelected: (GitUserInfo) -> Unit) :
    RecyclerView.Adapter<GitUserAdapter.GitUserInfoViewHolder>() {

    private lateinit var binding: ItemGitUserBinding

    inner class GitUserInfoViewHolder(private val binding: ItemGitUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onUserSelected(gitUserList[absoluteAdapterPosition])
            }
        }

        fun bind(gitUser: GitUserInfo) {
            binding.gitUser = gitUser
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitUserInfoViewHolder {
        binding = ItemGitUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GitUserInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitUserInfoViewHolder, position: Int) {
        val gitUserList = gitUserList[position]
        holder.bind(gitUserList)
    }

    override fun getItemCount() = gitUserList.size
}