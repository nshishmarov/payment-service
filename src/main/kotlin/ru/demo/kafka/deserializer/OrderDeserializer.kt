package ru.demo.kafka.deserializer

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer
import ru.demo.controller.dto.Order
import ru.demo.controller.dto.Payment

class OrderDeserializer : Deserializer<Order> {
    private val objectMapper = ObjectMapper()

    override fun deserialize(kafkaTopic: String?, orderByte: ByteArray?): Order =
        objectMapper.readValue(orderByte.toString(), Order::class.java)
}