package ru.yandex.practicum.smarthome.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTemperatureUpdate(Long deviceId, double temperature) {
        String message = String.format("Оборудование ID: %d, Температура: ", deviceId, temperature);
        kafkaTemplate.send(new ProducerRecord<>("temperature-topic", String.valueOf(deviceId), message));
    }
}
