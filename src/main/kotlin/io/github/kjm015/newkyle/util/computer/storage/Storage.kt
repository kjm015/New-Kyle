package io.github.kjm015.newkyle.util.computer.storage

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Storage(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    val id: Long = -1L,

    val manufacturer: String = "Unknown",
    val name: String = "Storage",

    val capacityGB: Long = -1,
    val formFactor: String = "Unknown",
    val boardInterface: String = "Unknown",
    val isNVMe: Boolean = false,
    val pcieGeneration: Int = -1,
    val maxReadSpeedMBps: Long = 0,
    val maxWriteSpeedMBps: Long = 0,

    var price: Double = 0.0
) {
    fun productName(): String = "$manufacturer $name"
}

class StorageList {
    var drives: List<Storage> = listOf()
}