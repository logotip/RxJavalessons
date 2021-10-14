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
            val type = when(it.id){
                R.id.btn_counter1->CounterType.ONE
                R.id.btn_counter2->CounterType.TWO
                R.id.btn_counter3->CounterType.THREE
                else->throw IllegalStateException("no")
            }
        }
        mainBinding.btnCounter1.setOnClickListener(listener)
        mainBinding.btnCounter2.setOnClickListener(listener)
        mainBinding.btnCounter3.setOnClickListener(listener)
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> mainBinding.btnCounter1.text = text
            1 -> mainBinding.btnCounter2.text = text
            2 -> mainBinding.btnCounter3.text = text
        }
    }



}