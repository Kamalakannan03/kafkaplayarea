package com.kafkaproducer.producerDemo.service;

import com.kafkaproducer.producerDemo.dto.UserDto;
import com.mycorp.mynamespace.sampleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserProducerService {
    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(String key, String value){
       CompletableFuture<SendResult<String,Object>> acknowledgement =  kafkaTemplate.send("topic_with_five_partition",key,value);

       acknowledgement.thenAccept(result ->{
           System.out.println("Message sent succesfully:"+result.getRecordMetadata().topic()+
                   "partition data==>"+result.getRecordMetadata().partition());
       }).exceptionally(ex ->{
           System.out.println("ERROR===>"+ex.getMessage());
           return null;
       });
    }
    public void sendMessageAsObject(String key, UserDto user){
        CompletableFuture<SendResult<String,Object>> acknowledgement =  kafkaTemplate.send("test_topic",key,user);

        acknowledgement.thenAccept(result ->{
            System.out.println("Message sent succesfully:"+result.getRecordMetadata().topic()+
                    "partition data==>"+result.getRecordMetadata().partition()+"User==>"+user);
        }).exceptionally(ex ->{
            System.out.println("ERROR===>"+ex.getMessage());
            return null;
        });
    }
    public void sendMessageAsAvro(String key, sampleRecord user){
        CompletableFuture<SendResult<String,Object>> acknowledgement =  kafkaTemplate.send("orders",key,user);

        acknowledgement.thenAccept(result ->{
            System.out.println("Message sent succesfully:"+result.getRecordMetadata().topic()+
                    "partition data==>"+result.getRecordMetadata().partition()+"User==>"+user);
        }).exceptionally(ex ->{
            System.out.println("ERROR===>"+ex.getMessage());
            return null;
        });
    }
}
