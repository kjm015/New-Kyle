package io.github.kjm015.kylenewer.util.computer.gpu

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class GPULoader(private val gpuRepository: GPURepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                GraphicsCard(
                        manufacturer = "ASRock",
                        productName = "Radeon RX 570 4 GB Phantom Gaming D",
                        memoryGB = 4,
                        memoryType = "GDDR5",
                        tdp = 150,
                        chipset = "Radeon RX 570",
                        length = 236,
                        fanCount = 2,
                        coreClock = 1168,
                        boostClock = 1244,
                        price = 129.99
                ),
                GraphicsCard(
                        manufacturer = "Asus",
                        productName = "GeForce GTX 1650 4 GB DUAL OC",
                        memoryGB = 4,
                        memoryType = "GDDR5",
                        tdp = 75,
                        chipset = "Nvidia GeForce GTX 1650",
                        length = 204,
                        fanCount = 2,
                        coreClock = 1485,
                        boostClock = 1755,
                        price = 149.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "GeForce GTX 1650 SUPER 4 GB WINDFORCE OC",
                        memoryGB = 4,
                        memoryType = "GDDR6",
                        tdp = 100,
                        chipset = "Nvidia GeForce GTX 1650 Super",
                        length = 225,
                        fanCount = 2,
                        coreClock = 1530,
                        boostClock = 1755,
                        price = 169.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "Radeon RX 5500 XT 4 GB OC",
                        memoryGB = 4,
                        memoryType = "GDDR6",
                        tdp = 130,
                        chipset = "Radeon RX 5500 XT",
                        length = 225,
                        fanCount = 2,
                        coreClock = 1647,
                        boostClock = 1845,
                        price = 179.99
                ),
                GraphicsCard(
                        manufacturer = "Sapphire",
                        productName = "Radeon RX 5500 XT 8 GB PULSE",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 135,
                        chipset = "Radeon RX 5500 XT",
                        length = 233,
                        fanCount = 2,
                        coreClock = 1607,
                        boostClock = 1845,
                        price = 209.99
                ),
                GraphicsCard(
                        manufacturer = "EVGA",
                        productName = "GeForce GTX 1660 SUPER 6 GB BLACK GAMING",
                        memoryGB = 6,
                        memoryType = "GDDR6",
                        tdp = 125,
                        chipset = "GeForce GTX 1660 Super",
                        length = 190,
                        fanCount = 1,
                        coreClock = 1530,
                        boostClock = 1785,
                        price = 229.99
                ),
                GraphicsCard(
                        manufacturer = "Sapphire",
                        productName = "Radeon RX 5600 XT 6 GB PULSE",
                        memoryGB = 6,
                        memoryType = "GDDR6",
                        tdp = 160,
                        chipset = "Radeon RX 5600 XT",
                        length = 254,
                        fanCount = 2,
                        coreClock = 1247,
                        boostClock = 1750,
                        price = 299.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "GeForce RTX 2060 6 GB OC Rev 2.0",
                        memoryGB = 6,
                        memoryType = "GDDR6",
                        tdp = 160,
                        chipset = "GeForce RTX 2060",
                        length = 226,
                        fanCount = 2,
                        coreClock = 1365,
                        boostClock = 1755,
                        price = 319.99
                ),
                GraphicsCard(
                        manufacturer = "Sapphire",
                        productName = "Radeon RX 5700 XT 8 GB PULSE",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 241,
                        chipset = "Radeon RX 5700 XT",
                        length = 254,
                        fanCount = 2,
                        coreClock = 1670,
                        boostClock = 1925,
                        price = 399.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "GeForce RTX 2060 SUPER 8 GB GAMING OC 3X",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 175,
                        chipset = "GeForce RTX 2060 Super",
                        length = 280,
                        fanCount = 3,
                        coreClock = 1470,
                        boostClock = 1710,
                        price = 419.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "GeForce RTX 2070 SUPER 8 GB WINDFORCE OC 3X",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 215,
                        chipset = "GeForce RTX 2070 Super",
                        length = 280,
                        fanCount = 3,
                        coreClock = 1605,
                        boostClock = 1785,
                        price = 499.99
                ),
                GraphicsCard(
                        manufacturer = "EVGA",
                        productName = "GeForce RTX 2070 SUPER 8 GB XC GAMING",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 215,
                        chipset = "GeForce RTX 2070 Super",
                        length = 270,
                        fanCount = 2,
                        coreClock = 1605,
                        boostClock = 1800,
                        price = 539.99
                ),
                GraphicsCard(
                        manufacturer = "Asus",
                        productName = "Asus GeForce RTX 2070 SUPER 8 GB STRIX GAMING Advanced",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 215,
                        chipset = "GeForce RTX 2070 Super",
                        length = 300,
                        fanCount = 3,
                        coreClock = 1635,
                        boostClock = 1830,
                        price = 584.99
                ),
                GraphicsCard(
                        manufacturer = "Zotac",
                        productName = "GeForce RTX 2080 SUPER 8 GB GAMING",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 250,
                        chipset = "GeForce RTX 2080 Super",
                        length = 308,
                        fanCount = 3,
                        coreClock = 1650,
                        boostClock = 1815,
                        price = 729.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "GeForce RTX 2080 SUPER 8 GB AORUS",
                        memoryGB = 8,
                        memoryType = "GDDR6",
                        tdp = 250,
                        chipset = "GeForce RTX 2080 Super",
                        length = 290,
                        fanCount = 3,
                        coreClock = 1650,
                        boostClock = 1860,
                        price = 769.99
                ),
                GraphicsCard(
                        manufacturer = "NVIDIA",
                        productName = "GeForce RTX 2080 Ti 11 GB Founders Edition",
                        memoryGB = 11,
                        memoryType = "GDDR6",
                        tdp = 260,
                        chipset = "GeForce RTX 2080 Ti",
                        length = 267,
                        fanCount = 2,
                        coreClock = 1350,
                        boostClock = 1635,
                        price = 1199.99
                ),
                GraphicsCard(
                        manufacturer = "Gigabyte",
                        productName = "GeForce RTX 2080 Ti 11 GB AORUS XTREME",
                        memoryGB = 11,
                        memoryType = "GDDR6",
                        tdp = 250,
                        chipset = "GeForce RTX 2080 Ti",
                        length = 290,
                        fanCount = 3,
                        coreClock = 1350,
                        boostClock = 1770,
                        price = 1299.99
                ),
                GraphicsCard(
                        manufacturer = "NVIDIA",
                        productName = "TITAN RTX 24 GB",
                        memoryGB = 24,
                        memoryType = "GDDR6",
                        tdp = 280,
                        chipset = "GeForce Titan RTX",
                        length = 267,
                        fanCount = 2,
                        coreClock = 1350,
                        boostClock = 1770,
                        price = 2490.00
                )
        ).forEach {
            if (!gpuRepository.existsByProductName(it.productName))
                gpuRepository.save(it)
        }
    }
}