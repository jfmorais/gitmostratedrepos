package com.curymorais.gittopreposbycury.data

import android.util.Log
import com.curymorais.gittopreposbycury.util.RetrofitInitializer
import com.curymorais.gittopreposbycury.data.remote.api.GithubService
import com.curymorais.gittopreposbycury.data.remote.model.GitApiResponse

class GitRepository{

    var gitRepos: GithubService = RetrofitInitializer().webservice

    suspend fun getRepos() = gitRepos.getRepos("kotlin","stars","desc")
    suspend fun getReposKot() = gitRepos.getReposKot("stars")
    suspend fun getReposTrad() : GitApiResponse {
       var repos =  gitRepos.getReposTradicional(1)
        Log.i("Cury", repos.incomplete_results.toString())
        return repos
    }
}
