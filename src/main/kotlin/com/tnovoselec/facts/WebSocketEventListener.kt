package com.tnovoselec.facts

import com.tnovoselec.facts.model.Player
import com.tnovoselec.facts.model.PlayerLeft
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent


@Component
class WebSocketEventListener {

    companion object {
        private val logger = LoggerFactory.getLogger(WebSocketEventListener::class.java)
    }

    @Autowired
    lateinit var messagingTemplate: SimpMessageSendingOperations

    @EventListener
    fun handleWebSocketConnectListener(event: SessionConnectedEvent) {
        logger.info("Received a new web socket connection")
    }

    @EventListener
    fun handleWebSocketDisconnectListener(event: SessionDisconnectEvent) {
        val headerAccessor = StompHeaderAccessor.wrap(event.message)

        val player = headerAccessor.sessionAttributes["player"] as Player
        logger.info("User Disconnected : " + player.name)

        val state = PlayerLeft(player)

        messagingTemplate.convertAndSend("/topic/public", state)
    }


}