package com.android.kcalculadora



import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun somaTest() {
         val res = soma(2.0, 3.0)
         assertEquals(5.0, res, 0.0)
    }
    @Test
    fun subTest() {
        val res = sub(2.0, 3.0)
        assertEquals(-1.0, res, 0.0)
    }

    @Test
    fun multiTest() {
        val res = multi(2.0, 3.0)
        assertEquals(6.0, res, 0.0)
    }
    @Test
    fun divTest() {
        val res = div(2.0, 3.0)
        assertEquals(0.6667, res, 0.0001)
    }



    private fun soma(i: Double, i1: Double): Double {
        return i+i1
    }
    private fun sub(i: Double, i1: Double): Double {
        return i-i1
    }
    private fun multi(i: Double, i1: Double): Double {
        return i*i1
    }
    private fun div(i: Double, i1: Double): Double {
        return i/i1
    }
}
