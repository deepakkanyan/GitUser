package com.example.gitusers.module

import com.example.gitusers.presenter.GitUserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val usersListViewModel = module {
    viewModel{ GitUserListViewModel(get()) }
}