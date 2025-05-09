package ru.demo.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.demo.controller.dto.Payment

@Service
class KafkaProducer(val kafkaTemplate: KafkaTemplate<String, Payment>) {
    fun sendMessage(content: Payment, kafkaTopic: String) = kafkaTemplate.send(kafkaTopic, content)
}