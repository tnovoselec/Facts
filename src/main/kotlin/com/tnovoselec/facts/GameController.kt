package com.tnovoselec.facts

import com.tnovoselec.facts.model.GameModel
import com.tnovoselec.facts.model.GameState
import com.tnovoselec.facts.model.PlayerJoined
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller


@Controller
class GameController {

    @Autowired
    lateinit var gameModel: GameModel

    @MessageMapping("/game.sendState")
    @SendTo("/topic/public")
    fun sendGameState(@Payload gameState: GameState) : GameState {
        return gameState
    }

    @MessageMapping("/game.playerJoin")
    fun playerJoined(@Payload playerJoined: PlayerJoined)  {
        gameModel.playerJoined(playerJoined.player)
    }
}