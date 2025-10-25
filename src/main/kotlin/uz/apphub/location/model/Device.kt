package uz.apphub.location.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@Entity
@Table(name = "devices")
data class Device(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String? = null,                   // foydalanuvchi nomi

    @Column(nullable = false)
    val deviceName: String,                     // telefon nomi

    val hasAllPermissions: Boolean? = null,     // barcha ruxsatlar berilganmi
    val isGpsEnabled: Boolean? = null,          // GPS yoqilganmi
    val isInternetConnected: Boolean? = null,   // internet mavjudmi
    val isListeningActive: Boolean? = null,     // location listener ishlimi
    val hasLocationPermission: Boolean? = null, // joylashuvga ruxsat bormi
    val shouldShowIcon: Boolean? = null,        // ikonka ko‘rsatiladimi

    @OneToMany(mappedBy = "device", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val locations: MutableList<Location> = mutableListOf(),

    @Column(updatable = false, nullable = false)
    val createdAt: Long = System.currentTimeMillis(),
)
