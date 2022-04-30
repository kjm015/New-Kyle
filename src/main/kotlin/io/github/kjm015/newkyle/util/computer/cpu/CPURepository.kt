package io.github.kjm015.newkyle.util.computer.cpu

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface CPURepository : CrudRepository<CPU, Long> {
  fun existsByName(name: String): Boolean
  fun findAllByPriceLessThan(price: Double): List<CPU>
}
