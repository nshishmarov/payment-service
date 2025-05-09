package ru.demo.kafka.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import ru.demo.controller.dto.Payment
import ru.demo.kafka.serializer.PaymentSerializer

@Configuration
class KafkaProducerConfig {

    @Autowired
    private lateinit var kafkaProperties: KafkaProperties

    @Bean
    fun producerFactory() : ProducerFactory<String, Payment> {
        val configs = kafkaProperties.buildProducerProperties()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = PaymentSerializer::class.java
        return DefaultKafkaProducerFactory(configs)
    }

    @Bean
    fun kafkaTemplate(
        producerFactory: ProducerFactory<String, Payment>
    ) : KafkaTemplate<String, Payment> =
        KafkaTemplate(producerFactory)
}