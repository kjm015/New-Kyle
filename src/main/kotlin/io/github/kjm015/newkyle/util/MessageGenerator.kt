package io.github.kjm015.newkyle.util

import com.fasterxml.jackson.databind.ObjectMapper
import net.dv8tion.jda.api.entities.User
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils

/**
 * This class generates all of the random shit that Kyle will say.
 * It also does formatting of messages that need to be processed in a specific way,
 * such as removing articles or changing the perspective of certain pronouns.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Service
class MessageGenerator {

  private val templates: MessageTemplates

  init {
    val url = ResourceUtils.getURL("classpath:content/templates.json")
    templates = ObjectMapper().readValue(url, MessageTemplates::class.java)
  }

  fun motionVerb(): String = templates.motionVerbs.random()


  fun derogatoryNoun(): String = templates.derogatoryNouns.random()

  fun location(): String = templates.locations.random()

  // List of weird side messages
  fun adjuncts(): String = templates.adjuncts.random()

  // Closing statements.
  fun closer(): String = templates.closers.random()

  // List of entry phrases.
  fun intent(): String = templates.intents.random()

  // List of verbs
  fun openers(): String = templates.openers.random()

  // List of intended targets of the action
  fun targets(): String = templates.subjects.random()

  // Exclamations for Kyle to yell
  fun exclamations(): String = templates.exclamations.random()

  fun tips() = templates.tips.random()

  fun prefaces() = templates.prefaces.random()

  /**
   * This method formats the judgement util to be sent to a specific user. The judgement
   * is put together using pieces from MessageGenerator given these preset formats.
   *
   * @param target - The user targeted for judgement that will also be mentioned in the util
   * @return the util String to be sent
   */
  fun generateJudgement(target: User): String {
    var msg = templates.templates.random()

    msg = msg.replace("%t", target.asMention)

    while (msg.contains("%d")) {
      msg = msg.replaceFirst("%d", derogatoryNoun())
    }

    msg = msg.replace("%l", location())

    // Return a random element from the list of Strings
    return msg
  }
}
