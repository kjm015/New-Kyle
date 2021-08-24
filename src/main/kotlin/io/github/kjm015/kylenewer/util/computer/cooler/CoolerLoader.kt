package io.github.kjm015.kylenewer.util.computer.cooler

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class CoolerLoader(private val repository: CoolerRepository) : ApplicationRunner {

    val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveFromFile().forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }

    private fun retrieveFromFile(): List<CPUCooler> {
        val file = ResourceUtils.getFile("classpath:computer/coolers.json")
        val list = mapper.readValue(file, CoolerList::class.java)
        return list.coolers
    }
}
