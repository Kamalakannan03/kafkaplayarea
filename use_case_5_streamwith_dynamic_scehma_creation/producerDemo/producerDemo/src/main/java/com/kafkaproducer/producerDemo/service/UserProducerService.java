package com.kafkaproducer.producerDemo.service;

import com.kafkaproducer.producerDemo.dto.UserDto;
import com.mycorp.mynamespace.CabLocation;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.reflect.ReflectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void sendMessageAsAvro(String key, CabLocation location){
        CompletableFuture<SendResult<String,Object>> acknowledgement =  kafkaTemplate.send("topic_5",key,location);

        acknowledgement.thenAccept(result ->{
            System.out.println("Message sent succesfully:"+result.getRecordMetadata().topic()+
                    "partition data==>"+result.getRecordMetadata().partition()+"location==>"+location);
        }).exceptionally(ex ->{
            System.out.println("ERROR===>"+ex.getMessage());
            return null;
        });
    }

    public void sendAvroFromPojo(String key, UserDto userDto) throws IOException {
//        Schema schema = ReflectData.get().getSchema(UserDto.class);
//        File schemaFile = new File("src/main/resources/avro/user.avsc");
//        FileWriter fileWriter = new FileWriter(schemaFile);
//        fileWriter.append(schema.toString(true));
//        fileWriter.close();
        Schema schema = ReflectData.get().getSchema(UserDto.class);
        GenericRecord avroRecord = new GenericData.Record(schema);
        avroRecord.put("id",userDto.getId());
        avroRecord.put("name",userDto.getName());
        avroRecord.put("location",userDto.getLocation());

        CompletableFuture<SendResult<String,Object>> acknowledgement =
                kafkaTemplate.send("topic_user",key,avroRecord);
        acknowledgement.thenAccept(result ->{
            System.out.println("Message sent succesfully:"+result.getRecordMetadata().topic()+
                    "partition data==>"+result.getRecordMetadata().partition()+"userDto==>"+avroRecord);
        }).exceptionally(ex ->{
            System.out.println("ERROR===>"+ex.getMessage());
            return null;
        });
    }
}
