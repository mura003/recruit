package com.synergist

import com.mitchellbosecke.pebble.PebbleEngine
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.io.StringWriter
import java.util.*
import javax.servlet.http.HttpServletResponse
import javax.validation.Validation

@RestController
class CharengerController {

    val engine = PebbleEngine.Builder().build()
    val factory = Validation.buildDefaultValidatorFactory();

    @GetMapping("/recruiting")
    fun index(): String {

        val writer = StringWriter()
        val template = engine.getTemplate("templates/index.peb")
        template.evaluate(writer);

        return writer.toString()
    }

    @GetMapping("/call")
    fun getCallMe(): String {
        return  Message("Almost! It's not GET. Keep trying.").toString()
    }

    @PostMapping("/call")
    fun postCallMe(response: HttpServletResponse): String {
        response.setHeader("X-Synm", Base64.getEncoder().encodeToString("synm=challenger".toByteArray()))
        return  Message("Great! Please register as /synm/challenge").toString()
    }

    @GetMapping("/challenge")
    fun getChallenge(response: HttpServletResponse): String {
        return  Message("Almost! It's not GET. Keep trying.").toString()
    }

    @PostMapping("/challenge")
    fun postChallenge(challenger: Challenger): String {

        val validator = factory.validator

        val constraintViolation = validator.validate(challenger)

        if( 0 < constraintViolation.size) {
            return Message(constraintViolation.stream().findFirst().get().message).toString()
        }

        return Message("Thanks!! Please come to the interview by all means").toString()
    }
}