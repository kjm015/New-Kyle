package io.github.kjm015.kylenewer.repository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class StoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1L

    @NotBlank
    @Size(min = 3, max = 64)
    var category: String = "none"

    @NotBlank
    @Size(min = 3, max = 128)
    var text: String = ""

    var author: String = "Unknown"

}