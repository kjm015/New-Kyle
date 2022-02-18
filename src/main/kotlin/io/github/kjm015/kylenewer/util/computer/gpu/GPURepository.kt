package io.github.kjm015.kylenewer.util.computer.gpu

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface GPURepository : CrudRepository<GraphicsCard, Long> {
    fun existsByProductName(productName: String): Boolean
    fun findAllByPriceLessThan(price: Double): List<GraphicsCard>
}