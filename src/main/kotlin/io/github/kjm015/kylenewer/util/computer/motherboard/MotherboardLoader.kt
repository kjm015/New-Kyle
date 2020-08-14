package io.github.kjm015.kylenewer.util.computer.motherboard

import io.github.kjm015.kylenewer.util.computer.MemoryGeneration
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class MotherboardLoader(private val repository: MotherboardRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "B550M DS3H",
                        formFactor = MotherboardFormFactor.MATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4600,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 94.99
                ),
                Motherboard(
                        manufacturer = "ASRock",
                        modelName = "B550M Pro4",
                        formFactor = MotherboardFormFactor.MATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4533,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 114.99
                ),
                Motherboard(
                        manufacturer = "MSI",
                        modelName = "MAG B550M BAZOOKA",
                        formFactor = MotherboardFormFactor.MATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 129.99
                ),
                Motherboard(
                        manufacturer = "MSI",
                        modelName = "B550-A PRO",
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 139.99
                ),
                Motherboard(
                        manufacturer = "Asus",
                        modelName = "PRIME X570-P",
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 149.99
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "B550 AORUS ELITE",
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4600,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 159.99
                ),
                Motherboard(
                        manufacturer = "Asus",
                        modelName = "TUF GAMING X570-PLUS",
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 164.99
                ),
                Motherboard(
                        manufacturer = "MSI",
                        modelName = "MAG B550 TOMAHAWK",
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4866,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 179.99
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "X570 AORUS ELITE",
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4000,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 199.99
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "X570 I AORUS PRO WIFI",
                        wifiType = 6,
                        formFactor = MotherboardFormFactor.ITX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 2,
                        maxMemoryLimitGB = 64,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 219.99
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "B550 VISION D",
                        wifiType = 6,
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 5000,
                        chipSet = "AMD B550",
                        socket = "AM4",
                        price = 259.99
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "X570 AORUS ULTRA",
                        wifiType = 6,
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 299.99
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "X570 AORUS MASTER",
                        wifiType = 6,
                        formFactor = MotherboardFormFactor.ATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 359.00
                ),
                Motherboard(
                        manufacturer = "Gigabyte",
                        modelName = "X570 AORUS XTREME",
                        wifiType = 6,
                        formFactor = MotherboardFormFactor.EATX,
                        memoryType = MemoryGeneration.DDR4,
                        memorySlots = 4,
                        maxMemoryLimitGB = 128,
                        maxMemorySpeed = 4400,
                        chipSet = "AMD X570",
                        socket = "AM4",
                        price = 699.99
                )
        ).forEach {
            if (!repository.existsByModelName(it.modelName)) {
                repository.save(it)
            }
        }
    }
}