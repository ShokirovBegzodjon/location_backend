package uz.apphub.location.services.device

import uz.apphub.location.model.Device
import uz.apphub.location.model.Location
import kotlin.String

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

data class DeviceRequest(

    val name: String? = null,
    val hasAllPermissions: Boolean? = null,
    val isGpsEnabled: Boolean? = null,
    val isInternetConnected: Boolean? = null,
    val isListeningActive: Boolean? = null,
    val hasLocationPermission: Boolean? = null,
    val shouldShowIcon: Boolean? = null,
)

data class DeviceResponse(

    val id: Long,
    val name: String? = null,
    val deviceName: String,
    val hasAllPermissions: Boolean? = null,
    val isGpsEnabled: Boolean? = null,
    val isInternetConnected: Boolean? = null,
    val isListeningActive: Boolean? = null,
    val hasLocationPermission: Boolean? = null,
    val shouldShowIcon: Boolean? = null,
    val location: Location,
)

fun DeviceRequest.toDevice(deviceName: String): Device {
    return Device(
        name = this.name,
        deviceName = deviceName,
        hasAllPermissions = this.hasAllPermissions,
        isGpsEnabled = this.isGpsEnabled,
        isInternetConnected = this.isInternetConnected,
        isListeningActive = this.isListeningActive,
        hasLocationPermission = this.hasLocationPermission,
        shouldShowIcon = this.shouldShowIcon,
    )
}

fun Device.toResponse(location: Location): DeviceResponse {
    return DeviceResponse(
        id = this.id,
        name = this.name,
        deviceName = this.deviceName,
        hasAllPermissions = this.hasAllPermissions,
        isGpsEnabled = this.isGpsEnabled,
        isInternetConnected = this.isInternetConnected,
        isListeningActive = this.isListeningActive,
        hasLocationPermission = this.hasLocationPermission,
        shouldShowIcon = this.shouldShowIcon,
        location = location,
    )
}