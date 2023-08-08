package machine

open class Coffee(val water: Int,val milk: Int, val beans: Int, val cost: Int)
class Espresso(water: Int = 250, milk: Int = 0, beans: Int = 16, cost: Int = 4) : Coffee(water, milk, beans, cost)
class Latte(water: Int = 350, milk: Int = 75, beans: Int = 20, cost: Int = 7) : Coffee(water, milk, beans, cost)
class Cappuccino(water: Int = 200, milk: Int = 100, beans: Int = 12, cost: Int = 6) : Coffee(water, milk, beans, cost)

val espresso: Espresso = Espresso()
val latte: Latte = Latte()
val cappuccino: Cappuccino = Cappuccino()


class Machine(var waterAmount: Int = 400,var milkAmount: Int = 540, var beansAmount: Int = 120, var cups: Int = 9, var cash: Int = 550) {
    fun available() {
        println("""
The coffee machine has:
$waterAmount ml of water
$milkAmount ml of milk
$beansAmount g of coffee beans
$cups disposable cups
${'$'}$cash of money
""")
    }

    fun start() {
        println("Write action (buy, fill, take, remaining, exit):")
        var action = readln()
        while (action != "exit") {
            if (action == "buy") {
                customer.buy()
            } else if (action == "fill") {
                machine.fill()
            } else if (action == "take") {
                machine.take()
            } else {
                machine.available()
            }
            println()
            println("Write action (buy, fill, take, remaining, exit):")
            action = readln()
        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        waterAmount += readln().toIntOrNull() ?: 0
        println("Write how many ml of milk you want to add:")
        milkAmount += readln().toIntOrNull() ?: 0
        println("Write how many grams of coffee beans you want to add:")
        beansAmount += readln().toIntOrNull() ?: 0
        println("Write how many disposable cups you want to add:")
        cups += readln().toIntOrNull() ?: 0
    }

    fun take() {
        println("I gave you \$$cash")
        cash = 0
    }
}

val machine: Machine = Machine()

class Customer {
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        var choice = readln().toIntOrNull() ?: 0
        if (choice == 1) {
            if (machine.waterAmount >= espresso.water) {
                if (machine.milkAmount >= espresso.milk) {
                    if (machine.beansAmount >= espresso.beans) {
                        if (machine.cups >= 1) {
                            machine.waterAmount -= espresso.water
                            machine.milkAmount -= espresso.milk
                            machine.beansAmount -= espresso.beans
                            machine.cups -= 1
                            machine.cash += espresso.cost
                            println("I have enough resources, making you a coffee!")
                        } else println("Sorry, not enough disposable cups!")
                    } else println("Sorry, not enough coffee beans!")
                } else println("Sorry, not enough milk!")
            } else println("Sorry, not enough water!")
        } else if (choice == 2) {
            if (machine.waterAmount >= latte.water) {
                if (machine.milkAmount >= latte.milk) {
                    if (machine.beansAmount >= latte.beans) {
                        if (machine.cups >= 1) {
                            machine.waterAmount -= latte.water
                            machine.milkAmount -= latte.milk
                            machine.beansAmount -= latte.beans
                            machine.cups -= 1
                            machine.cash += latte.cost
                            println("I have enough resources, making you a coffee!")
                        } else println("Sorry, not enough disposable cups!")
                    } else println("Sorry, not enough coffee beans!")
                } else println("Sorry, not enough milk!")
            } else println("Sorry, not enough water!")
        } else if (choice == 3) {
            if (machine.waterAmount >= cappuccino.water) {
                if (machine.milkAmount >= cappuccino.milk) {
                    if (machine.beansAmount >= cappuccino.beans) {
                        if (machine.cups >= 1) {
                            machine.waterAmount -= cappuccino.water
                            machine.milkAmount -= cappuccino.milk
                            machine.beansAmount -= cappuccino.beans
                            machine.cups -= 1
                            machine.cash += cappuccino.cost
                            println("I have enough resources, making you a coffee!")
                        } else println("Sorry, not enough disposable cups!")
                    } else println("Sorry, not enough coffee beans!")
                } else println("Sorry, not enough milk!")
            } else println("Sorry, not enough water!")
        } else {}
    }
}

val customer: Customer = Customer()

fun main() {
    machine.start()
}
