package uz.apphub.location.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uz.apphub.location.services.location.LocationRequest
import uz.apphub.location.services.location.LocationServices

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@RestController
@RequestMapping("/devices")
class LocationController(
    private val locationServices: LocationServices,
){
    @PostMapping("/{id}")
    fun startDeviceMonitoring(
        @PathVariable("id") deviceId: Long,
        @RequestBody locationRequest: LocationRequest,
    ): ResponseEntity<Unit> {
        locationServices.addLocation(deviceId, locationRequest)
        return ResponseEntity.ok().build()
    }
}
