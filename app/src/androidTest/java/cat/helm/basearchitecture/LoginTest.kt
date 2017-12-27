package cat.helm.basearchitecture

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import cat.helm.basearchitecture.customMatcher.ToastMatcher
import cat.helm.basearchitecture.repository.LoginRepository
import cat.helm.basearchitecture.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

/**
 * Created by Héctor on 21/12/2017.
 */
class LoginTest {

    @get:Rule
    val rule = EspressoDaggerMockRule()

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java, false, false)


    @Mock
    lateinit var repo: LoginRepository


//    @Test
//    fun userShouldNotLoginWithEmptyCredentials() {
//
//        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(click())
//        Espresso.onView(ViewMatchers.withText("Email and password should be filled")).inRoot(ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    }

    @Test
    fun a() {

       `when`(repo.login("username","password")).thenReturn(Result.of { "pastel" })

        activityRule.launchActivity(null)

        Espresso.onView(ViewMatchers.withId(R.id.username)).perform(typeText("user"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.password)).perform(typeText("password"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(click())
        Espresso.onView(ViewMatchers.withText("token: pastel")).inRoot(ToastMatcher()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}