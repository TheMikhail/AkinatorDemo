object QuestionGearboxAutomatic : Question {
    override fun description(): String {
        return "Вы хотите машину на автомате?"
    }

    override fun checkCondition(answer: Boolean, car: Car): Boolean
    {
        return (car.gearbox == Gearbox.Automatic)== answer
    }
}