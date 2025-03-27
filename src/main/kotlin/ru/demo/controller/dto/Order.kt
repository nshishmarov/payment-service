package ru.demo.controller.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.util.*

@AllArgsConstructor
@NoArgsConstructor
data class Order (
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    val orderDate: Date
)