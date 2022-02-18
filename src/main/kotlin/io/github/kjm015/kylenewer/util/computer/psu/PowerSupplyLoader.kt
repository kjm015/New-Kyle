package io.github.kjm015.kylenewer.util.computer.psu

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class PowerSupplyLoader(private val repository: PowerSupplyRepository) : ApplicationRunner {
    private val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveFromFile().forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }

    private fun retrieveFromFile(): List<PowerSupply> {
        val file = ResourceUtils.getFile("classpath:computer/psu.json")
        val list = mapper.readValue(file, PSUList::class.java)
        return list.powerSupplies
    }
}
