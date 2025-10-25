package uz.apphub.location.services.device

import org.springframework.stereotype.Service
import uz.apphub.location.model.Device
import uz.apphub.location.repository.DevicesRepository

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@Service
class DeviceServices(
    private val devicesRepository: DevicesRepository,
) {
    fun startDeviceMonitoring(deviceName: String): Long {
        val device = devicesRepository.findByDeviceName(deviceName)
            ?: devicesRepository.save(
                Device(
                    deviceName = deviceName,
                    isListeningActive = true,
                    shouldShowIcon = true,
                )
            )

        return device.id
    }

    fun updateDeviceInfo(deviceId: Long, deviceRequest: DeviceRequest) {
        val device = devicesRepository.findById(deviceId).orElseThrow()
            ?: throw IllegalArgumentException("Device with name $deviceId not found")
        var updatedDevice = device

        if (deviceRequest.name != null) {
            updatedDevice = updatedDevice.copy(name = deviceRequest.name)
        }
        if (deviceRequest.hasAllPermissions != null) {
            updatedDevice = updatedDevice.copy(hasAllPermissions = deviceRequest.hasAllPermissions)
        }
        if (deviceRequest.isGpsEnabled != null) {
            updatedDevice = updatedDevice.copy(isGpsEnabled = deviceRequest.isGpsEnabled)
        }
        if (deviceRequest.isInternetConnected != null) {
            updatedDevice = updatedDevice.copy(isInternetConnected = deviceRequest.isInternetConnected)
        }
        if (deviceRequest.isListeningActive != null) {
            updatedDevice = updatedDevice.copy(isListeningActive = deviceRequest.isListeningActive)
        }
        if (deviceRequest.hasLocationPermission != null) {
            updatedDevice = updatedDevice.copy(hasLocationPermission = deviceRequest.hasLocationPermission)
        }
        if (deviceRequest.shouldShowIcon != null) {
            updatedDevice = updatedDevice.copy(shouldShowIcon = deviceRequest.shouldShowIcon)
        }

        if (device == updatedDevice) {
            return
        }
        devicesRepository.save(updatedDevice)
    }

    fun getDeviceById(deviceId: Long): Device {
        return devicesRepository.findById(deviceId).orElseThrow()
            ?: throw IllegalArgumentException("Device with id $deviceId not found")
    }
}