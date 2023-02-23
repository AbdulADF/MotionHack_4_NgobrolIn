package com.abduladf.ngobrolin.model

data class ApiResponseUsers(
    val user: User
)

data class User(
    val id: String,
    val name: String,
    val phone: String,
    val username: String,
    val profilePhoto: String,
    val isVerified: Boolean,
)