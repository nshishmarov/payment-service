package ru.demo.mapper

import org.mapstruct.Mapper
import ru.demo.controller.dto.Payment
import ru.demo.domain.PaymentEntity

@Mapper(componentModel = "spring")
interface PaymentMapper {
    fun paymentToPaymentEntity(payment: Payment) : PaymentEntity
}