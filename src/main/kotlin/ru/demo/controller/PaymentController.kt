package ru.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.demo.controller.dto.Payment
import ru.demo.domain.PaymentEntity
import ru.demo.service.PaymentService

@RestController
class PaymentController(val paymentService: PaymentService) {

    @GetMapping("/payment/{id}")
    fun getPayment(@PathVariable("id") id: String): PaymentEntity? {
        return paymentService.findPaymentById(id)
    }

    @GetMapping("/payments")
    fun getAllPayments() : List<PaymentEntity> = paymentService.findAllPayments()

    @PostMapping("/payment")
    fun createPayment(@RequestBody payment: Payment) = paymentService.createPayment(payment)
}