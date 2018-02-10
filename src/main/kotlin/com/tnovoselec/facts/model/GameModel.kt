package com.tnovoselec.facts.model

import com.tnovoselec.facts.business.MessageSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class GameModel {

    @Autowired
    lateinit var messageSender: MessageSender

    private val players: MutableList<Player> = mutableListOf()

    fun playerJoined(player: Player) {
        players.add(player)
    }

    fun playerLeft(player: Player) {
        players.remove(player)
    }

    fun playerSubmittedAnswer(player: Player, answer: Answer) {

    }
}