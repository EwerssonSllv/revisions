package poo
import poo.exceptions.ObjectNotFoundException
import poo.model.Dashboard
import poo.model.Sales
import poo.model.User

fun main() {
    val sales1 = Sales(1, "SP", 1500.0, 200.0, 0.0).apply { setAmount(getAverage(), getSale()) }
    val sales2 = Sales(2, "PB", 2300.0, 300.0, 0.0).apply { setAmount(getAverage(), getSale()) }

    val dashboard1 = Dashboard(1, "Sales Q1", "First Quarter Report", listOf(sales1, sales2))
    val dashboard2 = Dashboard(2, "Sales Q2", "Second Quarter Report", listOf(sales1))

    val user1 = User(1, "Ewersson", "1234", dashboard1)
    val user2 = User(2, "Silva", "5678", dashboard2)

    val users = listOf(user1, user2)

    try {
        println("Enter user ID:")
        val inputId = readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("ID inválido!")

        val loggedUser = users.find { it.getId() == inputId }
            ?: throw ObjectNotFoundException("User not found!")

        println("Logged in user: ${loggedUser.getName()}")
        println("Associated Dashboards: ${loggedUser.getDashboard()?.toString()}")

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    } catch (e: NoSuchElementException) {
        println("Error: ${e.message}")
    } catch (e: ObjectNotFoundException) {
        println("Unexpected error: ${e.message}")
    }
}
