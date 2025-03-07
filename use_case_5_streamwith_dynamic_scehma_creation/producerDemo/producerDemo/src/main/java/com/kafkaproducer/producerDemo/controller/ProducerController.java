package com.kafkaproducer.producerDemo.controller;

import com.kafkaproducer.producerDemo.dto.MessageRequestDto;
import com.kafkaproducer.producerDemo.dto.UserDto;
import com.kafkaproducer.producerDemo.service.UserProducerService;
import com.mycorp.mynamespace.CabLocation;
import com.shared.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public void sendMessageAsAvro(@RequestParam String key, @RequestBody CabLocation cabLocation){
        System.out.println(cabLocation);
        userProducerService.sendMessageAsAvro(key, cabLocation);
    }

    @PostMapping("/sendAvroFromPojo")
    public void sendAvroFromPojo(@RequestParam String key, @RequestBody UserDto user) throws IOException {
        userProducerService.sendAvroFromPojo(key, user);
    }
    @PostMapping("/test")
    public void sendAvroFromPojo(@RequestParam String key, @RequestBody EmployeeDto employeeDto) throws IOException {
        System.out.println("Employee DTO==>"+employeeDto);
    }
}
