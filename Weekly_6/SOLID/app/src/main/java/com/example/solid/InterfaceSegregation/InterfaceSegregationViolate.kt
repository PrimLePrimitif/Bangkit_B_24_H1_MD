package com.example.solid.InterfaceSegregation

interface WeaponViolate {
    fun attack()
    fun reload()
    fun upgrade()
    fun required2Hand()
}

class AxeViolate() : WeaponViolate {
    override fun attack() {
        println("Attack with axe")
    }

    override fun reload() {
        // Why use this ? No usage
    }

    override fun upgrade() {
        println("upgrade the Weapon attack to 100Damage")
    }

    override fun required2Hand() {
        println("Axe Required you to use 2 hand")
    }
}


class Arrow() : WeaponViolate {
    override fun attack() {
       // Arrow need to be attached with Bow
    }

    override fun reload() {
        // Why use this ? No usage
    }

    override fun upgrade() {
        println("upgrade the arrow to fire")
    }

    override fun required2Hand() {
        // Gak perlu bang, arrow cukup 1 hand aja
    }
}
