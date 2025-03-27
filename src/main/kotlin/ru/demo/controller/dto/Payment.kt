package ru.demo.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.util.Date

@NoArgsConstructor
@AllArgsConstructor
data class Payment (
    @JsonProperty("name")
    val paymentName: String,
    @JsonProperty("contractId")
    val paymentDate: Date
)