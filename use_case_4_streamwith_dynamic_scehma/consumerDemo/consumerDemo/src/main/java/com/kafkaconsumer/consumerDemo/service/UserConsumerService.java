package com.kafkaconsumer.consumerDemo.service;

import com.mycorp.mynamespace.CabLocation;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {
/*    @KafkaListener(topics= "orders" , groupId = "test" , containerFactory = "kafkaListenerContainerFactory")
    public void consumeData(Object value){
        System.out.println("Value==>"+value);
    }*/
//@KafkaListener(topics= "topic_5" , groupId = "CabLocationGroup" , containerFactory = "kafkaListenerContainerFactory")
//public void consumeData(ConsumerRecord<String, CabLocation> data){
//    System.out.println("Value==>"+data.key());
//    System.out.println("Value==>"+data.value());
//}
@Autowired
private StreamsBuilder streamsBuilder;

    @PostConstruct
    public void streamTopology() {
        KStream<String, String> kStream = streamsBuilder.stream("topic_stream", Consumed.with(Serdes.String(), Serdes.String()));
        kStream.filter((key, value) -> value.startsWith("Message_")).mapValues((k, v) -> v.toUpperCase()).peek((k, v) -> System.out.println("Key : " + k + " Value : " + v)).to("car_gps_topic", Produced.with(Serdes.String(), Serdes.String()));

    }
}
