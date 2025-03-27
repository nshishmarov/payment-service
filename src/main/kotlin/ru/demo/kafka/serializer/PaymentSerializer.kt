package ru.demo.kafka.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.apache.kafka.common.serialization.Serializer
import ru.demo.controller.dto.Payment
import java.io.NotSerializableException

@NoArgsConstructor
@AllArgsConstructor
class PaymentSerializer : Serializer<Payment> {
    private val objectMapper = ObjectMapper()

    override fun serialize(kafkaTopic: String?, payment: Payment?): ByteArray =
        objectMapper.writeValueAsBytes(payment ?:
            throw NotSerializableException("Error with serialization!"))
}