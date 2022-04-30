package io.github.kjm015.newkyle.util.computer.psu

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface PowerSupplyRepository : CrudRepository<PowerSupply, Long> {
  fun existsByName(name: String): Boolean
  fun findAllByPriceLessThan(price: Double): List<PowerSupply>
  fun findAllByFormFactor(formFactor: PowerSupplyFormFactor): List<PowerSupply>
}
