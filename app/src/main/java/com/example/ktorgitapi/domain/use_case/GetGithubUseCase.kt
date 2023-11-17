package com.example.ktorgitapi.domain.use_case

import com.example.ktorgitapi.api.GitService
import com.example.ktorgitapi.common.Constants
import com.example.ktorgitapi.data.GithubDto
import io.ktor.client.call.body

class GetGithubUseCase {
    private val gitService = GitService()
    suspend fun get(): String {
        val response: String = try {
            gitService.getData(Constants.BASE_URL).body<GithubDto>()
                .let {
                    "Name of repository: ${it.name} \n" +
                            "Name of owner: ${it.owner?.login}\n" +
                    "Create at: ${it.createdAt}"
                }
        } catch (e: Exception) {
            "Can't get response"
        }
        return response
    }
}