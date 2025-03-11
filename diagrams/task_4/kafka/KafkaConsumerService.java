package ru.yandex.practicum.smarthome.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "temperature-topic", groupId = "device-group")
    public void listenTemperatureUpdate(ConsumerRecord<String, String> record) {
        String message = record.value();
        System.out.println("Полученная температура: " + message);
    }
}
