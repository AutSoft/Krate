package hu.autsoft.krate.gson.test

import hu.autsoft.krate.gson.GsonTestKrate
import hu.autsoft.krate.gson.TestModel
import hu.autsoft.krate.targetContext
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class GsonDelegateTest {

    private lateinit var krate: GsonTestKrate

    @Before
    fun setup() {
        krate = GsonTestKrate(targetContext)
    }

    @Test
    fun testInitialValues() {
        assertEquals(null, krate.simpleValue)
        assertEquals(null, krate.listOfValues)
    }

    @Test
    fun testSetSimpleValue() {
        val model = TestModel(x = 42, y = 3.141592, z = "shibboleth")

        krate.simpleValue = model

        assertEquals(model, krate.simpleValue)
    }

    @Test
    fun testRemoveSimpleValue() {
        val model = TestModel(x = 42, y = 3.141592, z = "shibboleth")

        krate.simpleValue = model
        krate.simpleValue = null

        assertEquals(null, krate.simpleValue)
    }

    @Test
    fun testSetListOfValues() {
        val list = listOf(
            TestModel(x = 42, y = 3.141592, z = "shibboleth"),
            TestModel(x = 13, y = 6.283185, z = "signal"),
            TestModel(x = 34, y = 2.718182, z = "bingo")
        )

        krate.listOfValues = list

        assertEquals(list, krate.listOfValues)
    }

    @Test
    fun testRemoveListOfValues() {
        val list = listOf(
            TestModel(x = 42, y = 3.141592, z = "shibboleth"),
            TestModel(x = 13, y = 6.283185, z = "signal"),
            TestModel(x = 34, y = 2.718182, z = "bingo")
        )

        krate.listOfValues = list
        krate.listOfValues = null

        assertEquals(null, krate.listOfValues)
    }

}
