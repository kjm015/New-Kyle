package io.github.kjm015.kylenewer.util

import java.nio.CharBuffer

/**
 * This class contains a lot of the constant values that are used across the application.
 * It's mostly a lot of String values for stuff that Kyle says over and over again.
 *
 * @author kjm015
 * @since 01/20/2019
 */
object AppConstants {

    const val DISASTER = "\n⣿⣿⣿⣿⡟⠄⣌⠻⣿⣿⣿⣿⣿⠟⠋⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⡇⢸⣭⡇⢽⣿⣿⠏⣀⣶⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⣿⣿⣷⣾⢿⣿⣿⣿⣿⣶⣭⣛⢃⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿\n⣿⣿⡛⠈⠛⠁⠙⠉⠛⠿⠛⢟⡿⣿⣷⡝⢿⡿⢻⣿⣿⣿⣿⣿⣿\n⣿⡹⠄⢀⣷⣶⣶⣿⣿⣿⣿⣷⣶⡍⠹⡿⠆⠙⣼⣿⣿⣿⣿⣿⣿\n⢫⣷⣧⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄⢀⣴⣶⣏⡛⢿⣿⣿⣿⣿\n⢸⣿⣿⠛⠿⣿⣿⣿⣿⣿⣿⠿⠁⠄⠄⣾⣿⣿⣿⡟⣨⣿⣿⣿⣿\n⡘⣿⣿⣧⣀⣀⣹⣏⢀⣀⣀⣀⣠⡄⢸⣿⣿⣿⣿⢀⣿⣿⣿⣿⣿\n⣷⣼⣋⠈⣿⣿⣿⣿⣿⣿⣿⣿⠟⠄⠈⠛⢿⠏⢙⠈⠁⠄⠙⣿⣿\n⣿⣿⣿⠄⠹⠟⠛⠉⠡⠿⣿⡏⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠘⣿\n⣿⣿⠿⠃⠄⠄⣀⡀⠄⠄⠈⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢹\n⠄⠄⢀⡆⣰⠟⠷⣤⠤⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n⠄⢀⠎⠄⠃⢀⠞⠉⢳⣴⣶⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀"

    val KYLE_LOCATION_QUESTIONS = arrayOf("Where is Kyle", "What happened to Kyle", "Where did Kyle go", "Where's Kyle", "凯尔在哪")

    val FLAG_TERM_1: CharSequence = CharBuffer.wrap(charArrayOf(78.toChar(), 73.toChar(), 71.toChar(), 71.toChar(), 69.toChar(), 82.toChar()))
    val FLAG_TERM_2: CharSequence = CharBuffer.wrap(charArrayOf(68.toChar(), 69.toChar(), 86.toChar(), 69.toChar(), 78.toChar()))

}
