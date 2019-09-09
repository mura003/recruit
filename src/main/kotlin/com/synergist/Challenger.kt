package com.synergist

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

class Challenger {

    @NotEmpty(message = "name can't be blank")
    var name: String = ""

    @NotEmpty(message = "email can't be blank")
    var email: String = ""

    @NotEmpty(message = "Look at the response header 'x-synm' of 'call' request. Hint: Please decode in a certain way.")
    @Pattern(regexp = "challenger", message = "Maybe a trivial mistake!!")
    var synm: String = ""
}