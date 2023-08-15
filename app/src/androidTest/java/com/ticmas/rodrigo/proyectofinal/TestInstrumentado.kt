package com.ticmas.rodrigo.proyectofinal.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ticmas.rodrigo.proyectofinal.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareTextsEqual() {
        // Ingresar texto en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.editText1)).perform(ViewActions.typeText("hello"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2)).perform(ViewActions.typeText("hello"))

        // Hacer clic en el botón "comparar"
         // Espresso.onView(ViewMatchers.withId(R.id.compareButton)).perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.compareButton)).perform(ViewActions.click())


        // Verificar que el resultado en el TextView sea correcto
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Resultado: Los textos son IGUALES")))
    }

    @Test
    fun mainActivity_compareTextsDifferent() {
        // Ingresar texto en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.editText1)).perform(ViewActions.typeText("hello"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2)).perform(ViewActions.typeText("world"))

        // Hacer clic en el botón "comparar"
        Espresso.onView(ViewMatchers.withId(R.id.compareButton)).perform(ViewActions.click())

        // Verificar que el resultado en el TextView sea correcto
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Resultado: Los textos son DIFERENTES")))
    }

    @Test
    fun mainActivity_compareTextsEmptyFields() {
        // No ingresar texto en los EditText

        // Hacer clic en el botón "comparar"
        Espresso.onView(ViewMatchers.withId(R.id.compareButton)).perform(ViewActions.click())

        // Verificar que el resultado en el TextView sea correcto
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Resultado: Campos incompletos")))
    }
}
