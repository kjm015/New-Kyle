package io.github.kjm015.kylenewer.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface StoryRepository : CrudRepository<StoryEntry, Long> {
    fun findAllByCategory(category: String): List<StoryEntry>
    fun findAllByAuthor(author: String): List<StoryEntry>
}