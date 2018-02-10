package com.tnovoselec.facts.model


sealed class GameState

// States pushed from client to server
data class PlayerJoined(val player: Player) : GameState()
data class PlayerLeft(val player: Player) : GameState()
data class PlayerProposedAnswer(val player: Player, val answer: Answer) : GameState()
data class PlayerSelectedAnswer(val player: Player, val answer: Answer) : GameState()

// States pushed from server to client
data class SendQuestion(val question: Question) : GameState()
data class ProposedAnswerIsCorrect(val answer: Answer) : GameState()

// States pushed from server to UI
