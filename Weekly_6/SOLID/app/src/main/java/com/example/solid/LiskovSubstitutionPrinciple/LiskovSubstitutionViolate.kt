package com.example.solid.LiskovSubstitutionPrinciple

open class DoorKeyViolate(var keyCode: Int = 2){
    protected val keycodeDefault: Int = 2
    open fun examineTheKey() {
        if (keyCode == 2) {
            println("This is a General key, used to open wood doors : $keyCode")
        }
    }
    open fun setKeycode(newKeyCode: Int) {
        this.keyCode = newKeyCode
    }

    open fun openDoor(target: Int) {
        if(this.keyCode == target) {
            println("Opening the Wooden door")
        }
    }
}

class DoorPrisonKeyViolate(keyCode: Int = 5) : DoorKeyViolate(keyCode) {

    override fun examineTheKey() {
        if (keyCode == 5) {
            println("This is a prison key, open all prison room in Muldraugh")
        }
    }

    override fun openDoor(target: Int) {
        if(this.keyCode == target) {
            println("Opening the prison door of muldraugh")
        }
    }

}

fun main() {
    var doorKeyViolate: DoorKeyViolate = DoorKeyViolate()
    // 3 : Prison Riverside
    // 4 : Prison LouisVille
    // 5 : Prison Muldraugh
    val prisonKey: DoorPrisonKeyViolate = DoorPrisonKeyViolate()

    prisonKey.examineTheKey()
    prisonKey.openDoor(5)

    prisonKey.openDoor(2)
    prisonKey.examineTheKey()
}