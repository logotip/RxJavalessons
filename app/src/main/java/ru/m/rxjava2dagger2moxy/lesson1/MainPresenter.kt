package ru.m.rxjava2dagger2moxy.lesson1

import ru.m.rxjava2dagger2moxy.R
import ru.m.rxjava2dagger2moxy.databinding.ActivityMainBinding

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(type: CounterType) {
        when (type) {
            CounterType.ONE -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            CounterType.TWO -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            CounterType.THREE -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}
enum class CounterType{
    ONE,TWO,THREE
}