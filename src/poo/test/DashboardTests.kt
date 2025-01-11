package poo.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import poo.exceptions.ObjectNotFoundException
import poo.model.Dashboard
import poo.model.Sales
import poo.model.User

class DashboardTests {

    @Test
    fun `must associate the dashboard with the user correctly`() {

        val sales1 = Sales(1, "SP", 1500.0, 200.0, 0.0).apply { setAmount(getAverage(), getSale()) }
        val dashboard1 = Dashboard(1, "Sales Q1", "First Quarter Report", listOf(sales1))
        val user = User(1, "Ewersson", "1234", dashboard1)

        val userDashboard = user.getDashboard()

        assertNotNull(userDashboard)
        assertEquals("Sales Q1", userDashboard?.getName())
    }

    @Test
    fun `should throw exception if user is not found`() {
        val users = listOf(
            User(1, "Ewersson", "1234", null),
            User(2, "Pedro", "5678", null)
        )

        val exception = assertThrows<ObjectNotFoundException> {
            val inputId = 3
            users.find { it.getId() == inputId } ?: throw ObjectNotFoundException("User with ID $inputId not found!")
        }

        assertEquals("User with ID 3 not found!", exception.message)
    }

    @Test
    fun `must calculate the correct sales amount`() {

        val sales = Sales(1, "SP", 1500.0, 200.0, 0.0)

        sales.setAmount(sales.getAverage(), sales.getSale())

        assertEquals(1700.0, sales.getAmount())
    }
}
