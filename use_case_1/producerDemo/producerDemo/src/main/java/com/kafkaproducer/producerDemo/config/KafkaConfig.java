package com.kafkaproducer.producerDemo.config;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.properties.sasl.mechanism}")
    private String saslMechanism;
    @Value("${spring.kafka.properties.sasl.jaas.config}")
    private String jaasConfig;
    @Value("${spring.kafka.properties.security.protocol}")
    private String securityProtocol;
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put("sasl.mechanism", saslMechanism);
        configProps.put("sasl.jaas.config", jaasConfig);
        configProps.put("security.protocol", securityProtocol);
        configProps.put("schema.registry.url","https://psrc-0kywq.us-east-2.aws.confluent.cloud");
        configProps.put("basic.auth.credentials.source","USER_INFO");
        configProps.put("schema.registry.basic.auth.user.info", "JERC6RN4V2XSH3JG:1/ygI7A+UiR1IelVJ1Ryqdtxcd9Lr4yx8irPvXWvR4T3+WM4TP1yuH7xl1RCsHW0");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}