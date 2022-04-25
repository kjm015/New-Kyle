package io.github.kjm015.newkyle.util.computer.cpu

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class CPULoader(private val cpuRepository: CPURepository) : ApplicationRunner {

    private val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveFromFile().forEach {
            if (!cpuRepository.existsByName(it.name))
                cpuRepository.save(it)
        }
    }

    private fun retrieveFromFile(): List<CPU> {
        val url = ResourceUtils.getURL("classpath:computer/cpu.json")
        val list = mapper.readValue(url, CPUList::class.java)
        return list.processors
    }
}
