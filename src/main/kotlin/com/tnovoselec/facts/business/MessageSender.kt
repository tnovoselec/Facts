package com.tnovoselec.facts.business

import com.tnovoselec.facts.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Component

@Component
class MessageSender {

    companion object {
        val PUBLIC = "/topic/public"
        val PLAYER = "/topic/player/{%s}"
        val UI = "/topic/ui"
    }

    @Autowired
    lateinit var messagingTemplate: SimpMessageSendingOperations

    fun sendQuestion(question: Question) {
        messagingTemplate.convertAndSend(PUBLIC, question)
    }
}