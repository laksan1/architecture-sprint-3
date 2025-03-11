package ru.yandex.practicum.smarthome.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
@Api(tags = "Devices", description = "Операции связанные с управлением устройств")
public class DeviceController {

    private final DeviceService deviceService;

    @ApiOperation(value = "Получить оборудование по id", response = DeviceDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDevice(@ApiParam(value = "Device ID", required = true) @PathVariable("id") Long id) {
        return ResponseEntity.ok(deviceService.getDevice(id));
    }

    @ApiOperation(value = "Обновить оборудование", response = DeviceDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<DeviceDto> updateDevice(@ApiParam(value = "Device ID", required = true) @PathVariable("id") Long id,
                                                  @RequestBody DeviceDto deviceDto) {
        return ResponseEntity.ok(deviceService.updateDevice(id, deviceDto));
    }

    @ApiOperation(value = "Включить оборудование")
    @PostMapping("/{id}/turn-on")
    public ResponseEntity<Void> turnOn(@ApiParam(value = "Device ID", required = true) @PathVariable("id") Long id) {
        deviceService.turnOn(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Выключить оборудование")
    @PostMapping("/{id}/turn-off")
    public ResponseEntity<Void> turnOff(@ApiParam(value = "Device ID", required = true) @PathVariable("id") Long id) {
        deviceService.turnOff(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Установить температуру для оборудования")
    @PostMapping("/{id}/set-temperature")
    public ResponseEntity<Void> setTemperature(@ApiParam(value = "Device ID", required = true) @PathVariable("id") Long id,
                                               @RequestParam double temperature) {
        deviceService.setTargetTemperature(id, temperature);
        return ResponseEntity.noContent().build();
    }
}
