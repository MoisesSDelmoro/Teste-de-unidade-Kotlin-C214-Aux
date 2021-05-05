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
        val calc = Calculadora()
        println("PASSOU AQUI")
    }

    @Test
    fun somaTest() {
        var calc = Calculadora()
        val res = calc.soma(2.0, 3.0)
        assertEquals(5.0, res, 0.0)
    }
    @Test
    fun subTest() {
        var calc = Calculadora()
        val res = calc.sub(2.0, 3.0)
        assertNotEquals(-10.0, res, 0.0)
    }

    @Test
    fun multiTest() {
        var calc = Calculadora()
        val res = calc.multi(2.0, 3.0)
        assertEquals(6.0, res, 0.0)
    }
    @Test
    fun divTest() {
        var calc = Calculadora()
        val res = calc.div(2.0, 3.0)
        assertEquals(0.6667, res, 0.0001)
    }

    @Test
    fun bhaskTest() {
        var calc = Calculadora()
        val res = calc.bhaskara(2, 8, 6)
        assertTrue(res)
    }

}
