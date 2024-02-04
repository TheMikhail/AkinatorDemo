object QuestionJDM : Question {

    override fun description(): String {
        return "Вы хотите Японскую машину?"
    }

    override fun checkCondition(answer: Boolean, car: Car): Boolean
    {
        return (car.market == Market.JDM)== answer
    }


}