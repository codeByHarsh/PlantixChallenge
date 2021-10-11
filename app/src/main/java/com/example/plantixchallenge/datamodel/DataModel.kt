package com.example.plantixchallenge.datamodel

data class DataModel(
    val title: String,
    val rows: List<Rows>,
) {
    data class Rows(
        val title: String,
        val description: String,
        val imageHref: String,
    )
}