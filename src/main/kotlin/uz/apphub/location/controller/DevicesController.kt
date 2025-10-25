package uz.apphub.location.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uz.apphub.location.model.Device
import uz.apphub.location.services.device.DeviceRequest
import uz.apphub.location.services.device.DeviceServices

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@RestController
@RequestMapping("/devices")
class DevicesController(
    private val deviceServices: DeviceServices,
){
    @PostMapping
    fun startDeviceMonitoring(
        @RequestBody deviceName: String,
    ): ResponseEntity<Long> {
        val deviceId = deviceServices.startDeviceMonitoring(deviceName)
        return ResponseEntity.ok(deviceId)
    }

    @PutMapping("/{id}")
    fun updateDeviceInfo(
        @PathVariable("id") deviceId: Long,
        @RequestBody deviceRequest: DeviceRequest,
    ): ResponseEntity<Unit> {
        deviceServices.updateDeviceInfo(deviceId, deviceRequest)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun getDeviceInfo(
        @PathVariable("id") deviceId: Long,
    ): ResponseEntity<Device> {
        val device = deviceServices.getDeviceById(deviceId)
        return ResponseEntity.ok(device)
    }
}
