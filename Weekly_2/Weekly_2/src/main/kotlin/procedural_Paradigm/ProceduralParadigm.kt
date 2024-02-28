package procedural_Paradigm

// Source Python OOP Book : No Stach Press
val SUIT_TUPLE: List<String> = arrayListOf("Spades", "Hearts", "Clubs", "Diamonds");
val RANK_TUPLE: List<String> = arrayListOf("Ace", "2", "3",
    "4", "5", "6",
    "7", "8", "9",
    "10", "Jack", "Queen", "King" );
val NCARDS: Int = 8

fun getCard(deckListIn: MutableList<MutableMap<String, String>>): MutableMap<String, String> {
    return deckListIn.removeLast()
}

fun shuffle(deckListIn: MutableList<MutableMap<String, String>>): MutableList<MutableMap<String, String>> {
    deckListIn.shuffle()
    return deckListIn
}

val startingDeckList: MutableList<MutableMap<String, String>> = mutableListOf();

fun main() {
    var score : Int = 50
    println("Welcome to Higher or Lower")
    println("You have to choose whether the next card shown will be higher or lower than the current card")
    println("If you right, 20 points; wrong -15 points")
    println("You have 50 points to start.\n")

    for (suit in SUIT_TUPLE) {
        RANK_TUPLE.forEachIndexed { index, rank ->
            val mutableMap: MutableMap<String, String> = mutableMapOf()
            mutableMap["rank"] = rank
            mutableMap["value"] = (index + 1).toString()
            mutableMap["suit"] = suit
            startingDeckList.add(mutableMap)
        }
    }
    while (true) {
        println()
        val gameDeckList = shuffle(startingDeckList)
        val currentCardInfo: Map<String, String> = getCard(gameDeckList)
        var currentCardRank: String = currentCardInfo["rank"] as String
        var currentCardValue: Int = currentCardInfo["rank"]?.toInt() as Int
        var currentCardSuit: String = currentCardInfo["suit"] as String

        println("Starting card is : $currentCardRank of $currentCardSuit")
        println()
        for (cardNumber in 0..NCARDS) {
            println("Will the next card be higher or lower than the $currentCardRank of $currentCardSuit ? Enter ( h or l ): ")
            val answer : String = readln().lowercase()
            val nextCardInfo: Map<String, String> = getCard(gameDeckList)
            val nextCardRank: String = nextCardInfo["rank"] as String
            val nextCardValue: Int = nextCardInfo["value"]?.toInt() as Int
            val nextCardSuit: String = nextCardInfo["suit"] as String

            println("Next Card is: $nextCardRank of $nextCardSuit")

            if (answer == "h") {
                if (nextCardValue > currentCardValue) {
                    println("You call it Right, it was Higher")
                    score += 20
                } else {
                    println("Sorry, it was not higher")
                    score -= 15
                }

            } else if (answer == "l") {

                if  (nextCardValue < currentCardValue) {
                    println("You call it Right, it was lower")
                    score += 20
                } else {
                    println("Sorry, it was not lower")
                    score -= 15
                }
            }
            println("Your Score is: $score")
            println()

            currentCardRank = nextCardRank
            currentCardValue = nextCardValue
            currentCardSuit = nextCardSuit
        }
        println("Would you like to play again? Press q to quit,")
        val playAgain: String = readln()
        if (playAgain == "q") {
            break
        }
    }
}