package com.abduladf.ngobrolin.model

data class ApiResponseProfessions(
    val metadata: Metadata,
    val data: List<Profession>
)

data class Profession(
    val id: Int,
    val name: String
)