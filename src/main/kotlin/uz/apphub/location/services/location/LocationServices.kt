package uz.apphub.location.services.location

import org.springframework.stereotype.Service
import uz.apphub.location.repository.DevicesRepository
import uz.apphub.location.repository.LocationRepository

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@Service
class LocationServices(
    private val devicesRepository: DevicesRepository,
    private val locationRepository: LocationRepository,
) {
    fun addLocation(deviceId: Long, locationRequest: LocationRequest) {
        val device = devicesRepository.findById(deviceId).orElseThrow {
            IllegalArgumentException("Device with id $deviceId not found")
        }
        val location = locationRequest.toLocation(device)
        locationRepository.save(location)
    }

    fun getLatestLocation(deviceId: Long): LocationResponse? {
        val location = locationRepository.findFirstByDeviceIdOrderByCreatedAtDesc(deviceId)
            ?: throw IllegalArgumentException("No location found for device with id $deviceId")
        return location.toResponse()
    }
}