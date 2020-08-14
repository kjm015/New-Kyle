package io.github.kjm015.kylenewer.util.computer.cpu

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CPULoader(private val cpuRepository: CPURepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                CPU(
                        company = "AMD",
                        name = "Ryzen 3 3100",
                        coreCount = 4,
                        threadCount = 8,
                        lithography = 7,
                        socket = "AM4",
                        price = 108.99
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 3 3300X",
                        coreCount = 4,
                        threadCount = 8,
                        lithography = 7,
                        socket = "AM4",
                        price = 129.99
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 5 3600",
                        coreCount = 6,
                        threadCount = 12,
                        lithography = 7,
                        socket = "AM4",
                        price = 174.99
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 5 3600X",
                        coreCount = 6,
                        threadCount = 12,
                        lithography = 7,
                        socket = "AM4",
                        price = 209.99
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 5 3600XT",
                        coreCount = 6,
                        threadCount = 12,
                        lithography = 7,
                        socket = "AM4",
                        price = 239.99
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 7 3700X",
                        coreCount = 8,
                        threadCount = 16,
                        lithography = 7,
                        socket = "AM4",
                        price = 283.00
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 7 3800X",
                        coreCount = 8,
                        threadCount = 16,
                        lithography = 7,
                        socket = "AM4",
                        price = 329.99
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 7 3800XT",
                        coreCount = 8,
                        threadCount = 16,
                        lithography = 7,
                        socket = "AM4",
                        price = 398.99,
                        includesCooler = false
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 9 3900X",
                        coreCount = 12,
                        threadCount = 24,
                        lithography = 7,
                        socket = "AM4",
                        price = 428.90
                ),
                CPU(
                        company = "AMD",
                        name = "Ryzen 9 3950X",
                        coreCount = 16,
                        threadCount = 32,
                        lithography = 7,
                        socket = "AM4",
                        price = 689.99,
                        includesCooler = false
                )
        ).forEach {
            if (!cpuRepository.existsByName(it.name))
                cpuRepository.save(it)
        }
    }
}