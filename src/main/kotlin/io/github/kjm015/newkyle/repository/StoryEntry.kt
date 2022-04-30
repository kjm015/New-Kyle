package io.github.kjm015.newkyle.repository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class StoryEntry {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = -1L

  var category: String = "none"

  var text: String = ""

  var author: String = "Unknown"
}
