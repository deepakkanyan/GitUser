package com.example.gitusers

import android.app.Application
import com.example.gitusers.module.gitHubApiModules
import com.example.gitusers.module.githubApiClientModule
import com.example.gitusers.module.usersInfoViewModel
import com.example.gitusers.module.usersListViewModel
import com.example.gitusers.presenter.GitUserListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GitApplication)
            modules(listOf(
                gitHubApiModules,
                githubApiClientModule,
                usersListViewModel,
                usersInfoViewModel
            ))
        }
    }
}