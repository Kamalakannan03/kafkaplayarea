package com.kafkaproducer.producerDemo.controller;

import com.kafkaproducer.producerDemo.dto.MessageRequestDto;
import com.kafkaproducer.producerDemo.dto.UserDto;
import com.kafkaproducer.producerDemo.service.UserProducerService;
import com.mycorp.mynamespace.sampleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send")
public class ProducerController {

    @Autowired
    private UserProducerService userProducerService;

    @PostMapping("/string")
    public void sendMessage(@RequestBody MessageRequestDto messageRequestDto){
        System.out.println(messageRequestDto);
        userProducerService.sendMessage(messageRequestDto.getKey(), (String) messageRequestDto.getValue());
    }
    @PostMapping("/object")
    public void sendMessageAsJsonObject(@RequestParam String key, @RequestBody UserDto messageRequestDto){
        System.out.println(messageRequestDto);
        userProducerService.sendMessageAsObject(key, messageRequestDto);
    }

    @PostMapping("/avro")
    public void sendMessageAsAvro(@RequestParam String key, @RequestBody sampleRecord messageRequestDto){
        System.out.println(messageRequestDto);
        userProducerService.sendMessageAsAvro(key, messageRequestDto);
    }
}
