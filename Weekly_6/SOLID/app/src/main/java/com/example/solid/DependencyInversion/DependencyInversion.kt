package com.example.solid.DependencyInversion

interface Weapon {
    fun attack()
    fun examine()
}

class Axe : Weapon {
    override fun attack() {
        println("Attack with Axe")
    }

    override fun examine() {
        println("This Axe is dumb")
    }
}

class Sword : Weapon {
    override fun attack() {
        println("Attack with sword")
    }

    override fun examine() {
        println("This sword is tumpul")
    }
}

class Player {
    var name: String = "Primitf"
    private var weapon: Weapon? = null

    fun setWeapon(weapon: Weapon) {
        this.weapon = weapon
    }

    fun printInfo() {
        println("Player name ${this.name}")
        val  weapon: Weapon? = this.weapon
        if (weapon != null) {
            println("Current weapon : ")
            weapon.examine()
        }
    }
}

fun main() {
    val player: Player = Player()
    val axe : Weapon = Axe()
    val sword: Weapon = Sword()
    player.setWeapon(axe)
    player.printInfo()

    player.setWeapon(sword)
    player.printInfo()

}
