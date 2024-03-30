package com.example.solid.InterfaceSegregation

interface Attackable {
    fun attack()
}

interface Reloadable {
    fun reload()
}

interface Upgradeable {
    fun upgrade()
}

class Axe : Attackable, Upgradeable {
    override fun attack() {
        println("Attack with Axe")
    }

    override fun upgrade() {
        println("Axe is upgradeable")
    }

}

class Bow: Attackable, Reloadable, Upgradeable {
    override fun attack() {
        println("Attack with Bow")
    }

    override fun reload() {
        println("Reload the Bow with Arrow")
    }

    override fun upgrade() {
        println("Bow is upgradeable")
    }

}
