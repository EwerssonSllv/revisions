package poo.model

class Sales(
    private var id: Int,
    private var state: String,
    private var sale: Double,
    private var average: Double,
    private var amount: Double
) {

    fun getId(): Int = id
    fun getState(): String = state
    fun getSale(): Double = sale
    fun getAverage(): Double = average
    fun getAmount(): Double = amount

    fun setId(newId: Int){
        id = newId
    }

    fun setState(newState: String){
        state = newState
    }

    fun setSale(newSale: Double){
        sale = newSale
    }

    fun setAverage(newAverage: Double){
        average = newAverage
    }

    fun setAmount(average: Double, sale: Double){
        amount = average + sale
    }


    override fun toString(): String {
        return "Sales(" +
                "Id:$id," +
                " State:'$state'," +
                " Sale: $sale," +
                " Average: $average," +
                " Amount: $amount)"
    }
}