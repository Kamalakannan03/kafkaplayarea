package com.kafkaconsumer.consumerDemo.config;
import com.kafkaconsumer.consumerDemo.dto.UserDto;
import com.mycorp.mynamespace.sampleRecord;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

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
    private String groupId="test";
    @Bean
    public ConsumerFactory<String, sampleRecord> consumerFactory() {


        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        configProps.put("sasl.mechanism", saslMechanism);
        configProps.put("sasl.jaas.config", jaasConfig);
        configProps.put("security.protocol", securityProtocol);
        configProps.put("schema.registry.url","https://psrc-0kywq.us-east-2.aws.confluent.cloud");
        configProps.put("basic.auth.credentials.source","USER_INFO");
        configProps.put("schema.registry.basic.auth.user.info", "JERC6RN4V2XSH3JG:1/ygI7A+UiR1IelVJ1Ryqdtxcd9Lr4yx8irPvXWvR4T3+WM4TP1yuH7xl1RCsHW0");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        configProps.put("specific.avro.reader","true");
        configProps.put("use.latest.version","false");
        KafkaAvroDeserializer deserializer = new KafkaAvroDeserializer();
        deserializer.configure(configProps,false);

//        JsonDeserializer<UserDto> deserializer = new JsonDeserializer<>(UserDto.class,false);
//        deserializer.addTrustedPackages("*");
//        return new DefaultKafkaConsumerFactory<>(configProps,new StringDeserializer(),deserializer);
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, sampleRecord> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, sampleRecord> factory=
                new ConcurrentKafkaListenerContainerFactory<>();
        //factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}