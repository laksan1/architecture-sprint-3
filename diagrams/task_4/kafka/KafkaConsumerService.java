package ru.yandex.practicum.smarthome.service;

import io.github.springwolf.annotations.AsyncApi;
import io.github.springwolf.annotations.SubscribeOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AsyncApi // Аннотация для генерации AsyncAPI
public class KafkaConsumerService {

    @KafkaListener(topics = "temperature-topic", groupId = "device-group")
    @SubscribeOperation(channelName = "temperature-topic", description = "Получение обновлений температуры") // Аннотация для генерации AsyncAPI
    public void listenTemperatureUpdate(ConsumerRecord<String, String> record) {
        String message = record.value();
        System.out.println("Полученная температура: " + message);
    }
}
