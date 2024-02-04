import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {

}
object SelectNewQuestion {
    val question = QuestionRepositoryClass().getQuestion().toMutableList()
    fun getNextQuestion(): Question? {
        if (question.isEmpty())
            return null
        else {
            val randomQuestion = question.random()
            question.remove(randomQuestion)
            return randomQuestion
        }
    }
}

@Composable
fun QuestionItem(
    state: ViewState.Question,
    onAction: (ViewAction) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 35.dp), verticalArrangement = Arrangement.Bottom) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = {
                ViewAction.onAnswerClicked(true)
            }
            ) {
                Text(text = "Да", fontSize = 32.sp)
            }
            TextButton(onClick = {
                ViewAction.onAnswerClicked(false)
            }) {
                Text(text = "Нет", fontSize = 32.sp)
            }

        }
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = state.toString())
        }
    }
}

fun ResultItem(state: ViewState.Result) {
    val car = CarRepositoryClass()
    val filteredCars = remember { mutableStateOf(car.getCar()) }
    val currentQuestion = remember { mutableStateOf(SelectNewQuestion.getNextQuestion()) }
    val state = currentQuestion.value

    if (state != null) {
        QuestionItem(state, onAnswer = { answer ->
            filteredCars.value = filteredCars.value.filterByAnswer(question, answer)
            currentQuestion.value = SelectNewQuestion.getNextQuestion()
        })
    } else {
        val yourCar = filteredCars.value
        when (yourCar.size) {
            0 -> Text(text = "Вам не подходит ни одна существующая машина")
            1 -> Text(text = "Ваша машина ${yourCar.single().name}")
            else -> Text(
                text = "Вам подходят следующие авто: ${
                    yourCar.joinToString(
                        prefix = "Вам подходят авто: ",
                        transform = { car -> car.name })
                }"
            )
        }
    }
}

@Composable
fun CarAkinatorScreen(
    state: ViewState,
    onAction: (ViewAction) -> Unit
) {
    when (state) {
        is Question -> QuestionItem()
        is Result -> ResultItem()
    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
