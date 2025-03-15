package ru.demo.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.demo.dto.Payment
import ru.demo.service.PaymentService

@RestController
class MainController(val paymentService: PaymentService) {
    @GetMapping("/payment/{id}")
    fun getPayment(@PathVariable("id") id: String): Payment? {
        return paymentService.findPaymentById(id)
    }

    @PostMapping("/payment")
    fun createPayment(@RequestBody payment: Payment) {
        paymentService.createPayment(payment)
    }
}