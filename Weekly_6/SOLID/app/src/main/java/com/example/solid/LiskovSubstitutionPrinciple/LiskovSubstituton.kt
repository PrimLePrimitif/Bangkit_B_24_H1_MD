package com.example.solid.LiskovSubstitutionPrinciple

open class DoorKey(var keyCode: Int = 2){
    protected val keycodeDefault: Int = 2
    open fun examineTheKey() {
        if (keyCode == 2) {
            println("This is a General key, used to open wood doors : $keyCode")
        } else {
            println("Dude i dont know what is this key.")
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

class DoorPrisonKey(keyCode: Int = 5) : DoorKey(keyCode) {

    override fun examineTheKey() {
        if (keyCode == 5) {
            println("This is a prison key, open all prison room in Muldraugh")
        } else {
            super.examineTheKey()
        }
    }

    override fun openDoor(target: Int) {
        if(this.keyCode == target) {
            println("Opening the prison door of muldraugh")
        } else {
            val currentKeycode: Int = this.keyCode
            setKeycode(keycodeDefault)
            super.openDoor(target)
            setKeycode(currentKeycode)
        }
    }

}

fun main() {
    var doorKey: DoorKey= DoorKey()
    // 3 : Prison Riverside
    // 4 : Prison LouisVille
    // 5 : Prison Muldraugh
    var prisonKey: DoorPrisonKey= DoorPrisonKey()

    prisonKey.examineTheKey()
    prisonKey.openDoor(2)
    prisonKey.examineTheKey()
}
