package uz.apphub.location.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uz.apphub.location.model.Location

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@Repository
interface LocationRepository: JpaRepository<Location, Long> {
    // deviceId bo‘yicha eng so‘nggi locationni olish
    fun findFirstByDeviceIdOrderByCreatedAtDesc(deviceId: Long): Location?
}