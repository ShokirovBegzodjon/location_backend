package uz.apphub.location.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uz.apphub.location.model.Device

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@Repository
interface DevicesRepository: JpaRepository<Device, Long> {
    fun findByDeviceName(deviceName: String): Device?
}