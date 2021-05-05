package com.android.kcalculadora



import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculadoraTest {

    @Before
    fun iniCalc(){
        println("PASSOU AQUI")

    }

    @Test
    fun somaTest() {
        val calc = Calculadora()
        val res = calc.soma(2.0, 3.0)
        assertEquals(5.0, res, 0.0)
    }
    @Test
    fun subTest() {
        val calc = Calculadora()
        val res = calc.sub(2.0, 3.0)
        assertNotEquals(-10.0, res, 0.0)
    }

    @Test
    fun multiTest() {
        val calc = Calculadora()
        val res = calc.multi(2.0, 3.0)
        assertEquals(6.0, res, 0.0)
    }
    @Test
    fun divTest() {
        val calc = Calculadora()
        val res = calc.div(2.0, 0.0)
        assertTrue("será?", res > 1)
    }

    @Test
    fun deltaTest() {
        val calc = Calculadora()
        val res = calc.bhaskara(2, 0, 6)
        assertFalse(res as Boolean)
    }

    @Test
    fun bhaskTest() {
        val calc = Calculadora()
        val esperado = mutableListOf(1.0, -9.0)
        val res = calc.bhaskara(1, 8, -9)
        assertEquals(esperado, res)
    }

}
