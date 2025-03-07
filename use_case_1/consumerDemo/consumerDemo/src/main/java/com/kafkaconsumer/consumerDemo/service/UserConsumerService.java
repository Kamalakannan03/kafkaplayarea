package com.kafkaconsumer.consumerDemo.service;

import com.mycorp.mynamespace.sampleRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {
/*    @KafkaListener(topics= "orders" , groupId = "test" , containerFactory = "kafkaListenerContainerFactory")
    public void consumeData(Object value){
        System.out.println("Value==>"+value);
    }*/
@KafkaListener(topics= "orders" , groupId = "test" , containerFactory = "kafkaListenerContainerFactory")
public void consumeData(ConsumerRecord<String, sampleRecord> data){
    System.out.println("Value==>"+data.value());
}
}
