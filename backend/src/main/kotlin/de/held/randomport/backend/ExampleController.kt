package de.held.randomport.backend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {

	@GetMapping("example")
	fun exampleEndpoint() = "foo"

}
