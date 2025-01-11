package poo.model

class User(
    private var id: Int,
    private var name: String,
    private var password: String,
    private var dashboard: Dashboard? = null
) {

    fun getId(): Int = id
    fun getName(): String = name
    fun getDashboard(): Dashboard? = dashboard

    fun setId(newId: Int){
        id = newId
    }

    fun setName(newName: String){
        name = newName
    }

    fun setDashboard(newDashboard: Dashboard){
        dashboard = newDashboard
    }

}