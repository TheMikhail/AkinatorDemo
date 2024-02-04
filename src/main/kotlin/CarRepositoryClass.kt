class CarRepositoryClass() : CarRepository {
    private val car1 = Car(Manufactory.HONDA, "Civic", Gearbox.Manual, Market.JDM)
    private val car2 = Car(Manufactory.VAZ, "2111", Gearbox.Manual, Market.RDM)
    private val car3 = Car(Manufactory.TOYOTA, "Corona", Gearbox.Automatic, Market.JDM)
    private val car4 = Car(Manufactory.MERCEDES, "w140", Gearbox.Automatic, Market.EDM)
    private val car5 = Car(Manufactory.BMW, "e39", Gearbox.Manual, Market.EDM)
    private val car6 = Car(Manufactory.VAZ, "Vesta", Gearbox.Automatic, Market.RDM)
    private val car7 = Car(Manufactory.DODGE, "Charger", Gearbox.Manual, Market.USDM)
    private val car8 = Car(Manufactory.LINCOLN, "Navigator", Gearbox.Automatic, Market.USDM)
    private val car9 = Car(Manufactory.HONDA, "Integra", Gearbox.Manual, Market.JDM)
    private val carFilter = listOf(car1, car2, car3, car4, car5, car6, car7, car8, car9)
    override fun getCar() : List<Car>{
        return carFilter
    }

}