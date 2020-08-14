package io.github.kjm015.kylenewer.util.computer.storage

import org.springframework.data.repository.CrudRepository

interface StorageRepository : CrudRepository<Storage, Long> {
    fun existsByName(name: String): Boolean
}