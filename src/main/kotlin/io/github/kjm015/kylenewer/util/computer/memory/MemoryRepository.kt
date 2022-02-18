package io.github.kjm015.kylenewer.util.computer.memory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemoryRepository : CrudRepository<MemoryKit, Long> {
    fun existsByName(name: String): Boolean
    fun findAllByPriceLessThan(price: Double): List<MemoryKit>
}