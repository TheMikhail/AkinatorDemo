sealed class ViewState {
    class Question(question: Question): ViewState()
    class Result(cars: List<Car>): ViewState()
}