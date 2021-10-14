package ru.m.rxjava2dagger2moxy.lesson1

import android.os.Bundle
import android.os.PersistableBundle
import ru.m.rxjava2dagger2moxy.R
import ru.m.rxjava2dagger2moxy.databinding.ActivityMainBinding

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
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




