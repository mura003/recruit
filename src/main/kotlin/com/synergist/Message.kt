package com.synergist

import com.fasterxml.jackson.databind.ObjectMapper

class Message constructor(val message: String) {

    override fun toString(): String {
        val objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(this)
    }
}