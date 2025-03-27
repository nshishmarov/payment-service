package ru.demo.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.demo.controller.dto.Payment
import ru.demo.domain.PaymentEntity
import ru.demo.mapper.PaymentMapper
import ru.demo.repository.PaymentJpaRepository

@Service
class PaymentService(
    val paymentJpaRepository: PaymentJpaRepository,
    val paymentMapper: PaymentMapper
) {
    fun findAllPayments() : List<PaymentEntity> = paymentJpaRepository.findAll().toList()

    fun findPaymentById(paymentId: String) : PaymentEntity? = paymentJpaRepository.findByIdOrNull(paymentId)

    fun createPayment(payment: Payment) = paymentJpaRepository.save(paymentMapper.paymentToPaymentEntity(payment))
}