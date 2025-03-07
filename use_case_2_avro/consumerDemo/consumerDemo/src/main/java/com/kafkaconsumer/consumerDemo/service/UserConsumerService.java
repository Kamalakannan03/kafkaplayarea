package com.kafkaconsumer.consumerDemo.service;

import com.mycorp.mynamespace.CabLocation;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {
/*    @KafkaListener(topics= "orders" , groupId = "test" , containerFactory = "kafkaListenerContainerFactory")
    public void consumeData(Object value){
        System.out.println("Value==>"+value);
    }*/
@KafkaListener(topics= "topic_5" , groupId = "CabLocationGroup" , containerFactory = "kafkaListenerContainerFactory")
public void consumeData(ConsumerRecord<String, CabLocation> data){
    System.out.println("Value==>"+data.key());
    System.out.println("Value==>"+data.value());
}
}
