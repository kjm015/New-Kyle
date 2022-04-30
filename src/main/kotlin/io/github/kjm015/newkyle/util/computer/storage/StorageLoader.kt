package io.github.kjm015.newkyle.util.computer.storage

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class StorageLoader(private val repository: StorageRepository) : ApplicationRunner {

  private val mapper = ObjectMapper()

  override fun run(args: ApplicationArguments) {
    loadFromFile().forEach {
      if (!repository.existsByName(it.name)) {
        repository.save(it)
      }
    }
  }

  private fun loadFromFile(): List<Storage> {
    val url = ResourceUtils.getURL("classpath:computer/ssd.json")
    val list = mapper.readValue(url, StorageList::class.java)
    return list.drives
  }
}
