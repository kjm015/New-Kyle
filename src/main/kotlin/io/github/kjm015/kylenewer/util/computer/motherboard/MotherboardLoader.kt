package io.github.kjm015.kylenewer.util.computer.motherboard

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.kjm015.kylenewer.util.computer.gpu.CardList
import io.github.kjm015.kylenewer.util.computer.memory.MemoryGeneration
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

    fun retrieveFromFile(): List<Motherboard> {
        val file = ResourceUtils.getFile("classpath:computer/motherboards.json")
        val list = mapper.readValue(file, MotherboardList::class.java)
        return list.motherboards
    }

}
