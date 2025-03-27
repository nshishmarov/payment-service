package ru.demo.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.demo.controller.dto.Payment
import ru.demo.domain.PaymentEntity

@Repository
interface PaymentJpaRepository : CrudRepository<PaymentEntity, String>