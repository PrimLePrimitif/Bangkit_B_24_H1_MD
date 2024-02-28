package oo_Paradigm
import procedural_Paradigm.*

class Card(var rank: String, var suit: String, value: String) {

    var value: Int
    var cardName: String

    init {
        this.value = value.toInt()
        this.cardName = "${this.rank} of ${this.suit}"
    }

}

class Deck {
    private val suit_tuple: List<String> = mutableListOf("Diamonds", "Clubs", "Hearts", "Spades")
    private val rank_tuple: List<String> = mutableListOf("Ace", "2", "3", "4",
        "5", "6", "7", "8",
        "9", "10", "J", "Q", "K")
    private val startingDeck: MutableList<Card> = mutableListOf()
    var playingDeck: MutableList<Card> = mutableListOf()
    lateinit var currentCardValue : Card
    init {
        for (suit in suit_tuple) {
            rank_tuple.forEachIndexed { index, rank ->
                val card: Card = Card(rank, suit, (index + 1).toString())
                this.startingDeck.add(card)
            }
        }
        this.startingDeck.shuffle()
        this.playingDeck = this.startingDeck
    }

    fun shuffle() {
        this.playingDeck = this.startingDeck
        this.playingDeck.shuffle()
    }

    fun getCard(): Card{
        return this.playingDeck.removeLast()
    }

}
fun main() {
    val deck: Deck = Deck()
    var score : Int = 50
    println("Welcome to Higher or Lower")
    println("You have to choose whether the next card shown will be higher or lower than the current card")
    println("If you right, 20 points; wrong -15 points")
    println("You have 50 points to start.\n")

    while (true) {
        println()
        deck.shuffle()
        val currentCardInfo: Card = deck.getCard()
        println(currentCardInfo.cardName)
        deck.currentCardValue = currentCardInfo

        println("Starting card is : ${deck.currentCardValue.cardName}")
        println()
        for (cardNumber in 0..NCARDS) {
            println("Will the next card be higher or lower than the ${deck.currentCardValue.cardName} ? Enter ( h or l ): ")
            val answer : String = readln().lowercase()
            val nextCardInfo: Card = deck.getCard()
            val nextCardRank: String = nextCardInfo.rank
            val nextCardValue: Int = nextCardInfo.value
            val nextCardSuit: String = nextCardInfo.suit

            println("Next Card is: $nextCardRank of $nextCardSuit")

            if (answer == "h") {
                if (nextCardValue > deck.currentCardValue.value) {
                    println("You call it Right, it was Higher")
                    score += 20
                } else {
                    println("Sorry, it was not higher")
                    score -= 15
                }

            } else if (answer == "l") {

                if  (nextCardValue < deck.currentCardValue.value) {
                    println("You call it Right, it was lower")
                    score += 20
                } else {
                    println("Sorry, it was not lower")
                    score -= 15
                }
            }
            println("Your Score is: $score")
            println()

            deck.currentCardValue = nextCardInfo
        }
        println("Would you like to play again? Press q to quit,")
        val playAgain: String = readln()
        if (playAgain == "q") {
            break
        }
    }
}