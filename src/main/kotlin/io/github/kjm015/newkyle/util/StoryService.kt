package io.github.kjm015.newkyle.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.util.*


/**
 * This class generates a story that was compiled from a list of sources.
 *
 * @author kjm015
 * @since 01/20/2019
 */
@Service
class StoryService {

  private val storyElements: StoryElements
  private val randy = Random()

  init {
    val url = ResourceUtils.getURL("classpath:content/stories.json")
    storyElements = ObjectMapper().readValue(url, StoryElements::class.java)
  }

  fun story(): String {
    val builder = StringBuilder()

    builder.append(storyElements.setups.random())
        .append(storyElements.foils.random())
        .append(storyElements.replies.random())
        .append(storyElements.affirmations.random())

    if (randy.nextBoolean() || randy.nextBoolean())
      builder.append(storyElements.flourishes.random())

    return builder.toString()
  }
}
