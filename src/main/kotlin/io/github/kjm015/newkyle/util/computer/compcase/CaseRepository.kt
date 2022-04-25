package io.github.kjm015.newkyle.util.computer.compcase

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface CaseRepository : CrudRepository<ComputerCase, Long> {
    fun existsByName(name: String): Boolean
    fun findAllByPriceLessThan(price: Double): List<ComputerCase>
}