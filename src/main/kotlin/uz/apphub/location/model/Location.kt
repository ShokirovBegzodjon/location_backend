package uz.apphub.location.model

import jakarta.persistence.*

/**
 * Created By Shokirov Begzod on 10/25/2025
 **/

@Entity
@Table(name = "locations")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val latitude: Double,
    val longitude: Double,
    val accuracy: Float,
    val speed: Float,

    @Column(updatable = false, nullable = false)
    val createdAt: Long = System.currentTimeMillis(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    val device: Device? = null
)
