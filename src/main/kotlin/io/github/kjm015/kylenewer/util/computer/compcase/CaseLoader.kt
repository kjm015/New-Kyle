package io.github.kjm015.kylenewer.util.computer.compcase

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class CaseLoader(private val repository: CaseRepository) : ApplicationRunner {

    private val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveFromFile().forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }

    private fun retrieveFromFile(): List<ComputerCase> {
        val file = ResourceUtils.getFile("classpath:computer/cases.json")
        val list = mapper.readValue(file, CaseList::class.java)
        return list.cases
    }
}
