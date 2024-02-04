interface Question {
    fun description(): String
    fun checkCondition(answer: Boolean, car: Car): Boolean
}