package io.github.kjm015.newkyle.util

data class MessageTemplates(
    val templates: List<String> = listOf(),
    val derogatoryNouns: List<String> = listOf(),
    val locations: List<String> = listOf(),
    val motionVerbs: List<String> = listOf(),
    val openers: List<String> = listOf(),
    val adjuncts: List<String> = listOf(),
    val closers: List<String> = listOf(),
    val subjects: List<String> = listOf(),
    val intents: List<String> = listOf(),
    val exclamations: List<String> = listOf(),
    val tips: List<String> = listOf(),
    val prefaces: List<String> = listOf()
)
