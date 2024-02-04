class QuestionRepositoryClass : QuestionRepository {

    private val allQuestion: List<Question> = listOf(
        QuestionJDM, QuestionEDM, QuestionUSDM,
        QuestionRDM, QuestionGearboxAutomatic, QuestionGearboxManual
    )

    override fun getQuestion(): List<Question> {
        return allQuestion
    }
}