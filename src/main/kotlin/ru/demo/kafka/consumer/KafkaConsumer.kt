package ru.demo.kafka.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    @KafkaListener(topics = ["order-topic"], groupId = "order-id")
    fun consume(message: String) {
        println("Message:$message")
    }
}