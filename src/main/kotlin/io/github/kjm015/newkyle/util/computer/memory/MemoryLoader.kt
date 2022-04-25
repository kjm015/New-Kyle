package io.github.kjm015.newkyle.util.computer.memory

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class MemoryLoader(private val repository: MemoryRepository) : ApplicationRunner {

    private val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveFromFile().forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }

    private fun retrieveFromFile(): List<MemoryKit> {
        val url = ResourceUtils.getURL("classpath:computer/ram.json")
        val list = mapper.readValue(url, MemoryList::class.java)
        return list.ram
    }
}
