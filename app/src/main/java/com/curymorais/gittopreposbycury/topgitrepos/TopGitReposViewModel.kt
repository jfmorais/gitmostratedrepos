package com.curymorais.gittopreposbycury.topgitrepos

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.curymorais.gittopreposbycury.data.GitRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

class TopGitReposViewModel : ViewModel(){

    private val repository: GitRepository = GitRepository()

    val firstTodo = liveData(Dispatchers.IO) {
        try {
//            val retrivedTodo = repository.getRepos()
//            val retrivedTodo = repository.getReposKot()
            val retrivedTodo = repository.getReposTrad()
            emit(retrivedTodo)
        }
        catch (e: HttpException) {
            Log.i("CURY_E", e.message() + e.code() )
        }
    }

}