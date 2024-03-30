package com.example.solid.SingleResponsibility

// Solution.. Make each class cuman punya satu tanggung jawab

class Player {
    var name: String = "PlayerDefault"
    var x: Int = 0
    var y: Int = 0
    lateinit var weapon: Weapon
    lateinit var health: HealthBar

    constructor(name: String, healthBar: HealthBar, weapon: Weapon) {
        this.name = name
        setHealthBar(healthBar)
        setPlayerWeapon(weapon)
    }
    constructor(healthBar: HealthBar, weapon: Weapon) {
        setHealthBar(healthBar)
        setPlayerWeapon(weapon)
    }

    fun setPlayerWeapon(weapon: Weapon) {
        this.weapon = weapon
    }

    fun move( x: Int, y: Int) {
        println("Player Move to $x, $y")
        this.x = x
        this.y = y
    }

    fun setHealthBar(healthBar: HealthBar) {
        this.health = healthBar
    }

    fun attack(enemy: String) {
        println("${this.name} Attack $enemy with ${this.weapon.getName()}: Given Damage ${this.weapon.getDamage()}")
    }

    fun healPlayer() {
        this.health.increaseHealthBar(5)
    }

    fun damagePlayer() {
        this.health.decreaseHealthBar(20)
    }

}

class Weapon(private var name: String,
             private var damage: Int = 100) {
    private var weaponAbility: String? = null
    private var defaultDamage = damage
    constructor(name: String, damage: Int, abilityCode: Int) : this(name, damage) {
        setWeaponAbility(abilityCode)
    }
    fun getDamage(): Int {
        return this.damage
    }
    fun getName(): String {
        return this.name
    }
    fun setWeaponAbility(code: Int) {
        when (code) {
            1 -> {
                this.weaponAbility = "Lightning"
                this.damage *= 2
            }
            2 -> {
                this.weaponAbility = "Fire"
                this.damage *= 3
            }
            3 -> {
                this.weaponAbility = "Ice"
                this.damage *= 4
            }
            else -> {
                this.weaponAbility = null
                this.damage = this.defaultDamage
            }
        }
    }
}

class GameSaver {
    lateinit var player: Player
    fun saveGame() {
        println("Saving data of $player.name")
        println("Game is saved")
        println()
    }

}

class HealthBar(private var healthBar: Int = 100) {
    fun increaseHealthBar(additionalHealth : Int) {
        this.healthBar += additionalHealth
    }

    fun decreaseHealthBar(minusHealth: Int) {
        this.healthBar -= minusHealth
    }
}

fun main() {

    var defaultHealthBar: HealthBar = HealthBar()
    var maximumHealthBar: HealthBar = HealthBar(1000)

    var axeWeapon: Weapon = Weapon("Axe", 150)
    var axeWeaponLightning: Weapon = Weapon("Axe", 150, 1)
    var bowFireWeapon: Weapon = Weapon("Bow", 50,3)

    var player1: Player = Player("Primitf", maximumHealthBar, axeWeapon)

    var player2: Player = Player("Fidel", defaultHealthBar, axeWeaponLightning)
    var player3: Player = Player("Fauzi", defaultHealthBar, bowFireWeapon)
    player1.attack("Fidel")

    player2.attack("Primitf")
    player3.attack("Primitf")

}