package uz.apphub.location.services.location

import uz.apphub.location.model.Device
import uz.apphub.location.model.Location

data class LocationRequest(
    val latitude: Double,
    val longitude: Double,
    val accuracy: Float,
    val speed: Float,
)

data class LocationResponse(
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val accuracy: Float,
    val speed: Float,
    val createdAt: Long,
)

fun LocationRequest.toLocation(device: Device) = Location(
    latitude = this.latitude,
    longitude = this.longitude,
    accuracy = this.accuracy,
    speed = this.speed,
    device = device
)

fun Location.toResponse() = LocationResponse(
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude,
    accuracy = this.accuracy,
    speed = this.speed,
    createdAt = this.createdAt
)