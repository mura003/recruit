package com.synergist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SynergistApplication

fun main(args: Array<String>) {
    runApplication<SynergistApplication>(*args)
}
