package com.abduladf.ngobrolin.model

data class ApiResponseMeetings(
    val metadata: Metadata,
    val meetings: List<Meeting>
)

data class Meeting(
    val id: String,
    val title: String,
    val description: String,
    val price: Int,
    val slots: Int,
    val startAt: String,
    val endAt: String,
    val isPrivate: Boolean,
    val creatorId: String,
    val creator: Creator
)