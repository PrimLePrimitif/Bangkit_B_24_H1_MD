package com.example.solid.DependencyInversion

class AxeViolate {
    fun attack() {
        println("Attack with Axe")
    }
}

class SwordViolate {
    fun attack() {
        println("Attack with sword")
    }
}

class PlayerViolate {
    var name: String = "Primitf"

    // Wkwk yakin, mau implementasi kaku kek gini ?
    // Gimana kalau mau add senjata lain ? Harus variable baru kah ??
    var weaponSword: SwordViolate? = null
    var weaponAxe: AxeViolate? = null

    fun setWeapon(weaponSword: SwordViolate) {
        this.weaponSword = weaponSword
    }

    fun setWeapon(weaponAxe: AxeViolate) {
        this.weaponAxe = weaponAxe
    }

    fun printInfo() {
        println("Player name ${this.name}")
        println("Current weapon : ")
        if(this.weaponAxe != null) {
            println("Axe")
        } else if(this.weaponSword != null) {
            println("Sword")
        }
    }
}

fun main() {
    val player: PlayerViolate = PlayerViolate()
    val axe : AxeViolate = AxeViolate()
    val sword: SwordViolate = SwordViolate()
    player.setWeapon(axe)
    player.setWeapon(sword)
    player.printInfo()

}