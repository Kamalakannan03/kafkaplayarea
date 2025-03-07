package com.kafkaproducer.producerDemo.dto;

public class MessageRequestDto {
    private String key;
    private Object value;

    @Override
    public String toString() {
        return "MessageRequestDto{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }

    public MessageRequestDto(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
