package com.jesse.c24xlsmallbur.data.model

data class SmallResponseItem(
    val age: String,
    val allOccupations: List<String>,
    val firstEpisode: String,
    val gender: String,
    val hair: String,
    val id: Int,
    val image: String,
    val name: String,
    val occupation: String,
    val relatives: List<Relative>,
    val url: String,
    val voicedBy: String,
    val wikiUrl: String
)