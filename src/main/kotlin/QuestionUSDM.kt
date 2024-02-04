object QuestionUSDM : Question {
    override fun description(): String {
        return "Вы хотите Американскую машину?"
    }

    override fun checkCondition(answer: Boolean, car: Car): Boolean
    {
        return (car.market == Market.USDM) == answer
    }
}