object QuestionRDM : Question{
    override fun description(): String {
        return "Вы хотите Российскую машину?"
    }

    override fun checkCondition(answer: Boolean, car: Car): Boolean
    {
        return (car.market == Market.RDM)== answer
    }
}