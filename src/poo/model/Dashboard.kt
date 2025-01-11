package poo.model

class Dashboard(
    private var id: Int,
    private var name: String,
    private var description: String,
    private var sales: List<Sales>,
) {

    override fun toString(): String {
        return "Dashboard: " +
                "id: $id," +
                " name: '$name'," +
                " description: '$description'," +
                " sales: $sales)"
    }
}