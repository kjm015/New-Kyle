package io.github.kjm015.kylenewer.util.computer.cpu

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface CPURepository : CrudRepository<CPU, Long> {
    fun existsByName(name: String): Boolean
}