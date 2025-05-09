package ru.demo.domain

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import lombok.EqualsAndHashCode
import lombok.ToString
import java.util.*

@Entity
@Table(name = "payments")
@EqualsAndHashCode
@ToString
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"paymentId\"", columnDefinition = "numeric(15,0)")
    @JsonProperty("paymentId")
    val paymentId: Long,
    @JsonProperty("paymentName")
    @Column(name = "\"paymentName\"", columnDefinition = "varchar(100)")
    val paymentName: String,
    @JsonProperty("paymentDate")
    @Column(name = "\"paymentDate\"", columnDefinition = "date")
    val paymentDate: Date
)