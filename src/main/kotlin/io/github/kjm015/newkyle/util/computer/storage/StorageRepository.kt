package io.github.kjm015.newkyle.util.computer.storage

import org.springframework.data.repository.CrudRepository

interface StorageRepository : CrudRepository<Storage, Long> {
  fun existsByName(name: String): Boolean
  fun findAllByPriceLessThan(price: Double): List<Storage>
}
