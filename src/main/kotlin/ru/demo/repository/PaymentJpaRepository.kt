package ru.demo.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.demo.dto.Payment

@Repository
interface PaymentJpaRepository : CrudRepository<Payment, String>