package com.abduladf.ngobrolin.model

data class ApiResponseListCreators(
    val metadata: Metadata,
    val creators: List<Creator>
)

data class Metadata(
    val page: Int,
    val size: Int,
    val total: Int,
    val totalPage: Int
)

data class Creator(
    val id: String,
    val name: String,
    val username: String,
    val profilePhoto: String,
    val isVerified: Boolean,
    val professions: List<Profession>
)