package io.github.kjm015.kylenewer.util.computer.memory

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class MemoryLoader(private val repository: MemoryRepository): ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Ripjaws V Series 8 GB (2 x 4 GB) DDR4-3200 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 4,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3200,
                        casLatency = 16,
                        price = 39.99
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Aegis 16 GB (2 x 8 GB) DDR4-3000 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 8,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3000,
                        casLatency = 16,
                        price = 50.99
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Ripjaws V Series 16 GB (2 x 8 GB) DDR4-3200 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 8,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3200,
                        casLatency = 16,
                        price = 57.99
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Ripjaws V Series 16 GB (2 x 8 GB) DDR4-3600 CL18",
                        moduleCount = 2,
                        moduleCapacityGB = 8,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 18,
                        price = 60.99
                ),
                MemoryKit(
                        manufacturer = "Crucial",
                        name = "Ballistix 16 GB (2 x 8 GB) DDR4-3600 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 8,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 16,
                        price = 74.99
                ),
                MemoryKit(
                        manufacturer = "Crucial",
                        name = "Ballistix RGB 16 GB (2 x 8 GB) DDR4-3200 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 8,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3200,
                        casLatency = 16,
                        hasRGB = true,
                        price = 80.98
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Ripjaws V Series 32 GB (2 x 8 GB) DDR4-3200 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 16,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3200,
                        casLatency = 16,
                        price = 108.99
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Ripjaws V Series 32 GB (2 x 8 GB) DDR4-3600 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 16,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 16,
                        price = 134.99
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Trident Z Neo 32 GB (2 x 8 GB) DDR4-3600 CL18",
                        moduleCount = 2,
                        moduleCapacityGB = 16,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 18,
                        price = 149.99,
                        hasRGB = true
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Trident Z Royal 32 GB (2 x 8 GB) DDR4-3600 CL16",
                        moduleCount = 2,
                        moduleCapacityGB = 16,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 16,
                        price = 194.99,
                        hasRGB = true
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Ripjaws V 64 GB (2 x 8 GB) DDR4-3600 CL18",
                        moduleCount = 2,
                        moduleCapacityGB = 32,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 18,
                        price = 229.99
                ),
                MemoryKit(
                        manufacturer = "G.Skill",
                        name = "Trident Z Neo 64 GB (2 x 8 GB) DDR4-3600 CL18",
                        moduleCount = 2,
                        moduleCapacityGB = 16,
                        memoryGeneration = MemoryGeneration.DDR4,
                        speed = 3600,
                        casLatency = 18,
                        price = 259.99,
                        hasRGB = true
                )
        ).forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }
}