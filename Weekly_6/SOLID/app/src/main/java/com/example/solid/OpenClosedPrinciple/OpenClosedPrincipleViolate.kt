package com.example.solid.OpenClosedPrinciple

interface ItemViolate {
    fun setBasePrice()
    fun getPrice(): Float
}

class ShopViolate {
    fun calculateTotal(itemViolates: List<ItemViolate>) : Float {
        var totalPrice : Float  = 0.0f
        for (item in itemViolates) {
            when(item) {
                // Say the shop need tax
                is AxeViolate -> {
                    totalPrice += item.getPrice() + (item.getPrice() * 0.5f)
                }

                is BowViolate -> {
                    totalPrice += item.getPrice() + (item.getPrice() * 0.12f)
                }

                is ArrowViolate -> {
                    totalPrice += item.getPrice() + (item.getPrice() * 0.05f)
                }
                else -> {

                }
            }
        }
        return totalPrice
    }
}

// Weapon Class
class AxeViolate(private var price: Float = 100f) :  ItemViolate {
    init{
        setBasePrice()
    }
    override fun setBasePrice() {
        this.price = 200f
    }

    override fun getPrice(): Float {
        return this.price
    }

}

class BowViolate(private var price: Float = 100f) : ItemViolate {

    init{
        setBasePrice()
    }
    override fun setBasePrice() {
        this.price = 250f
    }

    override fun getPrice(): Float {
        return this.price
    }

}

class ArrowViolate(private var price: Float = 100f) : ItemViolate{
    init{
        setBasePrice()
    }
    override fun setBasePrice() {
        this.price = 25f
    }

    override fun getPrice(): Float {
        return this.price
    }

}

fun main() {

    var arrowViolateViolate1: ItemViolate = ArrowViolate()
    var arrowViolateViolate2: ItemViolate = ArrowViolate()

    var axeViolateViolate1: ItemViolate = AxeViolate()
    var axeViolateViolate2: ItemViolate = AxeViolate()

    var bowViolateViolate1: ItemViolate = BowViolate()
    var bowViolateViolate2: ItemViolate= BowViolate()

    var listItemViolates: MutableList<ItemViolate> = mutableListOf(
        arrowViolateViolate1, arrowViolateViolate2,
        axeViolateViolate1, axeViolateViolate2,
        bowViolateViolate1, bowViolateViolate2)

    var shopViolateMart: ShopViolate = ShopViolate()
    var totalPrice = shopViolateMart.calculateTotal(listItemViolates)
    println("Your total Price is : $totalPrice USD")
}
