package io.github.kjm015.kylenewer.util.computer.gpu

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class GPULoader(private val gpuRepository: GPURepository) : ApplicationRunner {

    private val mapper = ObjectMapper()

    override fun run(args: ApplicationArguments) {
        retrieveCardsFromFile().forEach {
            if (!gpuRepository.existsByProductName(it.productName)) {
                gpuRepository.save(it)
            }
        }
    }

    private fun retrieveCardsFromFile(): List<GraphicsCard> {
        val url = ResourceUtils.getURL("classpath:computer/gpu.json")
        val list = mapper.readValue(url, CardList::class.java)
        return list.cards
    }
}
