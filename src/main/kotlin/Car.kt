data class Car(
    val manufactory: Manufactory, val model: String, val gearbox: Gearbox, val market : Market
) {

    val name = manufactory.nameMark + model
}