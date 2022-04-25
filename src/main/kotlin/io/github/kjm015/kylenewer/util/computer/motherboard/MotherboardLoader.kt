package io.github.kjm015.kylenewer.util.computer.motherboard

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class MotherboardLoader(private val repository: MotherboardRepository) : ApplicationRunner {

    private val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveFromFile().forEach {
            if (!repository.existsByModelName(it.modelName)) {
                repository.save(it)
            }
        }
    }

    private fun retrieveFromFile(): List<Motherboard> {
        val url = ResourceUtils.getURL("classpath:computer/motherboards.json")
        val list = mapper.readValue(url, MotherboardList::class.java)
        return list.motherboards
    }

}
