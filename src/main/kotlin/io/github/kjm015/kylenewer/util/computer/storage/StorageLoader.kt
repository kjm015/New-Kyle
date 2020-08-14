package io.github.kjm015.kylenewer.util.computer.storage

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class StorageLoader(private val repository: StorageRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                Storage(
                        manufacturer = "TCSunBow",
                        name = "X3 240 GB",
                        formFactor = "2.5\"",
                        boardInterface = "SATA",
                        capacityGB = 240,
                        price = 26.99
                ),
                Storage(
                        manufacturer = "Crucial",
                        name = "P2 250 GB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 250,
                        isNVMe = true,
                        price = 42.49
                ),
                Storage(
                        manufacturer = "Team",
                        name = "GX1 480 GB",
                        formFactor = "2.5\"",
                        boardInterface = "SATA",
                        capacityGB = 480,
                        price = 43.99
                ),
                Storage(
                        manufacturer = "Team",
                        name = "GX1 512 GB",
                        formFactor = "2.5\"",
                        boardInterface = "SATA",
                        capacityGB = 512,
                        price = 45.99
                ),
                Storage(
                        manufacturer = "Western Digital",
                        name = "Blue SN550 500 GB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 500,
                        isNVMe = true,
                        price = 59.99
                ),
                Storage(
                        manufacturer = "Team",
                        name = "GX2 1 TB",
                        formFactor = "2.5\"",
                        boardInterface = "SATA",
                        capacityGB = 1024,
                        price = 85.99
                ),
                Storage(
                        manufacturer = "Western Digital",
                        name = "Blue SN550 1 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 1024,
                        isNVMe = true,
                        price = 104.99
                ),
                Storage(
                        manufacturer = "Western Digital",
                        name = "Black SN750 1 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 1024,
                        isNVMe = true,
                        price = 134.99
                ),
                Storage(
                        manufacturer = "Samsung",
                        name = "970 Evo 1 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 1024,
                        isNVMe = true,
                        price = 169.99
                ),
                Storage(
                        manufacturer = "Team",
                        name = "GX2 2 TB",
                        formFactor = "2.5\"",
                        boardInterface = "SATA",
                        capacityGB = 2048,
                        price = 189.99
                ),
                Storage(
                        manufacturer = "Corsair",
                        name = "MP600 Force Series Gen4 1 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 1024,
                        isNVMe = true,
                        price = 194.99
                ),
                Storage(
                        manufacturer = "Western Digital",
                        name = "Black SN750 2 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 2048,
                        isNVMe = true,
                        price = 329.99
                ),
                Storage(
                        manufacturer = "Corsair",
                        name = "MP600 Force Series Gen4 2 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 2048,
                        isNVMe = true,
                        price = 379.99
                ),
                Storage(
                        manufacturer = "Gigabyte",
                        name = "AORUS NVMe Gen4 2 TB",
                        formFactor = "M.2-2280",
                        boardInterface = "M.2",
                        capacityGB = 2048,
                        isNVMe = true,
                        price = 399.99
                )
        ).forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }
}