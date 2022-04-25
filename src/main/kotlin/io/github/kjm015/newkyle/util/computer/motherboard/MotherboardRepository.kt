package io.github.kjm015.newkyle.util.computer.motherboard

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface MotherboardRepository : CrudRepository<Motherboard, Long> {
    fun existsByModelName(modelName: String): Boolean
    fun findAllBySocket(socket: String): List<Motherboard>
    fun findAllByPriceLessThan(price: Double): List<Motherboard>
}