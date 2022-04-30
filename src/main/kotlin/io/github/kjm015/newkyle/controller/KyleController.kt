package io.github.kjm015.newkyle.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * This controller is in place in case we want to implement a home page or MVC functionality
 * sometime in the future. Right now, it doesn't really do much.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@RestController
class KyleController {

  /**
   * Tell the world hello! This is currently the placeholder home page.
   *
   * @return a pleasant greeting
   */
  @GetMapping(path = ["/", "/hello"])
  @ResponseStatus(HttpStatus.OK)
  fun sayHello(): String = "Hello, world!"
}
