package ru.m.rxjava2dagger2moxy.lesson1

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()


    fun counterClick(type: CounterType) {
        when (type) {
            CounterType.COUNTER1 -> {
                val nextValue = model.next(0)
                view.setButtonText(CounterType.COUNTER1, nextValue.toString())
            }
            CounterType.COUNTER2 -> {
                val nextValue = model.next(1)
                view.setButtonText(CounterType.COUNTER2, nextValue.toString())
            }
            CounterType.COUNTER3 -> {
                val nextValue = model.next(2)
                view.setButtonText(CounterType.COUNTER3, nextValue.toString())
            }
        }
    }
}
enum class CounterType{
    COUNTER1,COUNTER2,COUNTER3
}




