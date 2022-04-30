package io.github.kjm015.newkyle.util.computer.cooler

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
    val url = ResourceUtils.getURL("classpath:computer/coolers.json")
    val list = mapper.readValue(url, CoolerList::class.java)
    return list.coolers
  }
}
