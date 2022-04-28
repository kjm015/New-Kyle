package io.github.kjm015.newkyle.util.computer.cooler

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface CoolerRepository : CrudRepository<CPUCooler, Long> {
    fun existsByName(name: String): Boolean
    fun findByName(name: String): CPUCooler
    fun findAllByPriceLessThan(price: Double): List<CPUCooler>
    fun findAllByPriceGreaterThan(price: Double): List<CPUCooler>
}