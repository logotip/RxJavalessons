package ru.m.rxjava2dagger2moxy.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.m.rxjava2dagger2moxy.R
import ru.m.rxjava2dagger2moxy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainBinding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val listener = View.OnClickListener {
            when(it.id){
                R.id.btn_counter1->presenter.counterClick(CounterType.COUNTER1)
                R.id.btn_counter2->presenter.counterClick(CounterType.COUNTER2)
                R.id.btn_counter3->presenter.counterClick(CounterType.COUNTER3)
            }
        }
        mainBinding.btnCounter1.setOnClickListener(listener)
        mainBinding.btnCounter2.setOnClickListener(listener)
        mainBinding.btnCounter3.setOnClickListener(listener)
    }


    override fun setButtonText(type: CounterType, text: String) {
        when (type) {
            CounterType.COUNTER1 -> mainBinding.btnCounter1.text = text
            CounterType.COUNTER2 -> mainBinding.btnCounter2.text = text
            CounterType.COUNTER3 -> mainBinding.btnCounter3.text = text
        }
    }
}