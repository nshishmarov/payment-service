package ru.demo.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "payment")
data class Payment (
    @JsonProperty("name")
    val name: String,
    @JsonProperty("id")
    @Id
    val id : Long,
    @JsonProperty("contractId")
    val contractId: Long
)