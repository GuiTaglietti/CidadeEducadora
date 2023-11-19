package br.upf.cidadeeducadora.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String) : RuntimeException(){}