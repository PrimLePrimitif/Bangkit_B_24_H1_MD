package com.example.solid.SingleResponsibility

class PlayerViolate {
    private var health: Float = 100f
    private var x: Int = 0
    private var y: Int = 0
    private var name: String = "Primitif"
    private var weapon: String = "Knife"

   fun move(x : Int, y: Int) {
        this.x = x
        this.y = y
        println("$this.name move into $x,$y")
    }

   fun attack(enemy : String) {
        println("$this.name Attack into $enemy with ${this.weapon}")
    }

    // Ini boleh jadi responsible User, karena user bakalan pake, dan ada juga variablenya
    private fun setWeapon(weapon: String) {
        this.weapon = weapon
    }

    // This one ? Not really, masa player dikasih kemampuan set Special Ability untuk senjatanya?
    // Kita pengennya ya kelas dari Weapon aja yang set
    private fun setWeaponSpecialAbility(weapon: String, ability: String) {
        this.weapon = weapon + ability
    }

    // This is should not be Player Responsible
    private fun saveGame() {
        println("Saving Game ...")
        /* Masukin Further logic*/
    }
    // How about this ?
    private fun increaseHealthBar(plusHealth: Int) {
        this.health += plusHealth
    }

    // How about this ?
    private fun decreaseHealthBar(minusHealth: Int) {
        this.health -= minusHealth
    }

}
