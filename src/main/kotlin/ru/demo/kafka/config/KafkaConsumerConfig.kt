package ru.demo.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import ru.demo.controller.dto.Payment
import ru.demo.kafka.deserializer.OrderDeserializer

@Configuration
class KafkaConsumerConfig {

    @Autowired
    private lateinit var kafkaProperties: KafkaProperties

    private fun consumerFactory() : ConsumerFactory<String, Payment> {
        val configs = kafkaProperties.buildConsumerProperties()
        configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = OrderDeserializer::class.java
        return DefaultKafkaConsumerFactory(configs)
    }

    @Bean
    fun kafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, Payment>
    ) : ConcurrentKafkaListenerContainerFactory<String, Payment> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Payment>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}