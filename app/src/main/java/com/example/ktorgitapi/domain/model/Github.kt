package com.example.ktorgitapi.domain.model

import com.example.ktorgitapi.data.GithubDto

data class Github(

    var name: String?,
    var homepage: String?,
    var language: String?,
    var login: String?,
    var createdAt: String?,
)

fun GithubDto.toGithub(): Github? {
    return Github(
        name = name,
        homepage = homepage,
        language = language,
        login = owner?.login,
        createdAt = updatedAt
    )
}
