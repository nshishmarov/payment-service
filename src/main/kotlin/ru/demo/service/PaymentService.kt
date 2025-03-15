package ru.demo.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.demo.dto.Payment
import ru.demo.repository.PaymentJpaRepository

@Service
class PaymentService(private val paymentJpaRepository: PaymentJpaRepository) {
    fun findAllPayments() : List<Payment> = paymentJpaRepository.findAll().toList()
    fun findPaymentById(paymentId: String) : Payment? = paymentJpaRepository.findByIdOrNull(paymentId)
    fun createPayment(payment: Payment) = paymentJpaRepository.save(payment)
}