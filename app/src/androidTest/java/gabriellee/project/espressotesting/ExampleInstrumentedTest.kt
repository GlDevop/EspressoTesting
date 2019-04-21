package gabriellee.project.espressotesting

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("gabriellee.project.espressotesting", appContext.packageName)
    }

    @Test
    fun user_can_enter_first_name() {
        onView(withId(R.id.firstName)).perform(typeText("Daniel"))
    }

    @Test
    fun user_can_enter_last_name() {
        onView(withId(R.id.lastName)).perform(typeText("Malone"))
    }

    @Test
    fun when_user_enter_first_and_last_name_check_to_confirm_that_message_is_correct() {
        onView(withId(R.id.firstName)).perform(typeText("Jake"))
        onView(withId(R.id.lastName)).perform(typeText("Smith"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome Jake Smith!")))
    }

    @Test
    fun first_message_again() {
        onView(withId(R.id.firstName)).perform(typeText("Mel"))
        onView(withId(R.id.lastName)).perform(typeText("Johnson"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome Mel Johnson!")))
    }




}
