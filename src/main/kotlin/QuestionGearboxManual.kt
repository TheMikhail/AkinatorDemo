object QuestionGearboxManual : Question {
    override fun description(): String {
        return "Вы хотите машину на механике?"
    }

    override fun checkCondition(answer: Boolean, car: Car): Boolean
    {
        return (car.gearbox == Gearbox.Manual)== answer
    }
}