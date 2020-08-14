package io.github.kjm015.kylenewer.util.computer.compcase

import io.github.kjm015.kylenewer.util.computer.motherboard.MotherboardFormFactor
import io.github.kjm015.kylenewer.util.computer.psu.PowerSupplyFormFactor
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CaseLoader(private val repository: CaseRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                ComputerCase(
                        manufacturer = "Cooler Master",
                        name = "MasterBox Q300L",
                        formFactor = MotherboardFormFactor.MATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 360,
                        maxRadiatorSupport = 240,
                        price = 49.99
                ),
                ComputerCase(
                        manufacturer = "Fractal Design",
                        name = "Focus G",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 380,
                        maxRadiatorSupport = 280,
                        price = 59.99
                ),
                ComputerCase(
                        manufacturer = "Cooler Master",
                        name = "MasterBox MB311L ARGB Airflow",
                        formFactor = MotherboardFormFactor.MATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 344,
                        maxRadiatorSupport = 280,
                        price = 67.98
                ),
                ComputerCase(
                        manufacturer = "NZXT",
                        name = "H510",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 381,
                        maxRadiatorSupport = 280,
                        price = 69.99
                ),
                ComputerCase(
                        manufacturer = "NZXT",
                        name = "H210",
                        formFactor = MotherboardFormFactor.ITX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 325,
                        maxRadiatorSupport = 240,
                        price = 79.99
                ),
                ComputerCase(
                        manufacturer = "Fractal Design",
                        name = "Meshify C",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 315,
                        maxRadiatorSupport = 360,
                        price = 98.99
                ),
                ComputerCase(
                        manufacturer = "Fractal Design",
                        name = "Define Mini C TG",
                        formFactor = MotherboardFormFactor.MATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 315,
                        maxRadiatorSupport = 280,
                        price = 98.99
                ),
                ComputerCase(
                        manufacturer = "be quiet!",
                        name = "Pure Base 500DX",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 369,
                        maxRadiatorSupport = 360,
                        price = 98.99
                ),
                ComputerCase(
                        manufacturer = "Cooler Master",
                        name = "MasterBox TD500 Mesh",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 410,
                        maxRadiatorSupport = 360,
                        price = 99.99
                ),
                ComputerCase(
                        manufacturer = "Cooler Master",
                        name = "MasterCase H500 ARGB",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 410,
                        maxRadiatorSupport = 360,
                        price = 119.99
                ),
                ComputerCase(
                        manufacturer = "Lian Li",
                        name = "PC-O11 Dynamic",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 420,
                        maxRadiatorSupport = 360,
                        price = 134.99
                ),
                ComputerCase(
                        manufacturer = "NZXT",
                        name = "H710",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 413,
                        maxRadiatorSupport = 360,
                        price = 137.99
                ),
                ComputerCase(
                        manufacturer = "Fractal Design",
                        name = "Meshify S2",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 440,
                        maxRadiatorSupport = 420,
                        price = 147.99
                ),
                ComputerCase(
                        manufacturer = "Fractal Design",
                        name = "Define 7",
                        formFactor = MotherboardFormFactor.ATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 467,
                        maxRadiatorSupport = 420,
                        price = 169.99
                ),
                ComputerCase(
                        manufacturer = "Fractal Design",
                        name = "Define 7 XL Light",
                        formFactor = MotherboardFormFactor.EATX,
                        psuFormFactor = PowerSupplyFormFactor.ATX,
                        maxGPULength = 524,
                        maxRadiatorSupport = 480,
                        price = 207.99
                )
        ).forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }
}