package com.tnovoselec.facts

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FactsApplication

fun main(args: Array<String>) {
    SpringApplication.run(FactsApplication::class.java, *args)
}
