package io.github.kjm015.newkyle.util.computer.gpu

import javax.persistence.*
import net.minidev.json.annotate.JsonIgnore

@Entity
data class GraphicsCard(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    val id: Long = -1L,
    val manufacturer: String = "Unknown",
    val productName: String = "Graphics Card",
    val chipset: String = "Unknown",
    val coreClock: Int = -1,
    val boostClock: Int = -1,
    val memoryGB: Int = -1,
    val memoryType: String = "Unknown",
    val length: Int = -1,
    val tdp: Int = -1,
    val fanCount: Int = -1,
    var price: Double = 0.00
)

class CardList {
  var cards: List<GraphicsCard> = listOf()
}
