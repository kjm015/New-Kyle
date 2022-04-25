package io.github.kjm015.newkyle.util.computer.compcase

import io.github.kjm015.newkyle.util.computer.motherboard.MotherboardFormFactor
import io.github.kjm015.newkyle.util.computer.psu.PowerSupplyFormFactor
import net.minidev.json.annotate.JsonIgnore
import javax.persistence.*

@Entity
data class ComputerCase(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long = -1L,

    var name: String = "Case",
    var manufacturer: String = "Unknown",
    var formFactor: MotherboardFormFactor = MotherboardFormFactor.UNKNOWN,
    var psuFormFactor: PowerSupplyFormFactor = PowerSupplyFormFactor.UNKNOWN,
    var maxRadiatorSupport: Int = -1,
    var maxGPULength: Int = -1,
    var price: Double = 0.00
)

class CaseList {
    var cases: List<ComputerCase> = listOf()
}