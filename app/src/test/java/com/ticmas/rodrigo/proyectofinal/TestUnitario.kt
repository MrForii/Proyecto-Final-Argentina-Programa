package com.ticmas.rodrigo.proyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ticmas.rodrigo.proyectofinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(dispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun mainViewModel_TestCompareTexts_EmptyFields() = testScope.runBlockingTest {
        viewModel.compareTexts("", "")
        val result = viewModel.result.value
        assertEquals("Campos incompletos", result)
    }

    @Test
    fun mainViewModel_TestCompareTexts_EqualTexts() = testScope.runBlockingTest {
        viewModel.compareTexts("hello", "hello")
        val result = viewModel.result.value
        assertEquals("Los textos son IGUALES", result)
    }

    @Test
    fun mainViewModel_TestCompareTexts_DifferentTexts() = testScope.runBlockingTest {
        viewModel.compareTexts("hello", "world")
        val result = viewModel.result.value
        assertEquals("Los textos son DIFERENTES", result)
    }

}
