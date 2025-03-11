package ru.yandex.practicum.smarthome.service;

import io.github.springwolf.annotations.AsyncApi;
import io.github.springwolf.annotations.PublishOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AsyncApi // Аннотация для генерации AsyncAPI
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PublishOperation(channelName = "temperature-topic", description = "Отправка данных о температуре устройства") // Аннотация для генерации AsyncAPI
    public void sendTemperatureUpdate(String message) {
        kafkaTemplate.send("temperature-topic", message);
    }
}
