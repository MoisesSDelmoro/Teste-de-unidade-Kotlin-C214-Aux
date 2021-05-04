package com.android.kcalculadora

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val FAKE_STRING = "HELLO_WORLD"

    @Before
    fun CheckCamp(){
        assertTrue(true)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun subtraction_noCorrect(){
        assertNotEquals(6,10-5)
    }
}
