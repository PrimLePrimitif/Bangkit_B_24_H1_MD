package com.example.solid.OpenClosedPrinciple
interface Item {
    fun setBasePrice()
    fun getPrice(): Float
    fun getPriceWithTax(): Float
}

class Shop {
    fun calculateTotal(itemViolates: List<Item>) : Float {
        var totalPrice : Float  = 0.0f
        for (item in itemViolates) {
            totalPrice += item.getPriceWithTax()
        }
        return totalPrice
    }
}

// Weapon Class
class Axe(private var price: Float = 100f) :  Item {
    init{
        setBasePrice()
    }
    override fun setBasePrice() {
        this.price = 200f
    }

    override fun getPrice(): Float {
        return this.price
    }

    override fun getPriceWithTax(): Float {
        return this.price +  (this.price * 0.5f)
    }

}

class Bow(private var price: Float = 100f) : Item {

    init{
        setBasePrice()
    }
    override fun setBasePrice() {
        this.price = 250f
    }

    override fun getPrice(): Float {
        return this.price
    }

    override fun getPriceWithTax(): Float {
        return this.price +  (this.price * 0.12f)
    }

}

class Arrow(private var price: Float = 100f) : Item{
    init{
        setBasePrice()
    }
    override fun setBasePrice() {
        this.price = 25f
    }

    override fun getPrice(): Float {
        return this.price
    }

    override fun getPriceWithTax(): Float {
        return this.price +  (this.price * 0.05f)
    }

}

fun main() {

    var arrow1: Item = Arrow()
    var arrow2: Item = Arrow()

    var axe1: Item = Axe()
    var axe2: Item = Axe()

    var bow1: Item = Bow()
    var bow2: Item = Bow()

    var listItem: MutableList<Item> = mutableListOf(
        arrow1, arrow2,
        axe1, axe2,
        bow1, bow2)

    var shopMart: Shop = Shop()
    var totalPrice = shopMart.calculateTotal(listItem)
    println("Your total Price is : $totalPrice USD")
}
