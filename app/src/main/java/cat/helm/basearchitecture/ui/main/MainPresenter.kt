package cat.helm.basearchitecture.ui.main

import cat.helm.basearchitecture.login.LoginInteractor
import cat.helm.basearchitecture.ui.exception.AndroidExceptionHandler
import javax.inject.Inject

/**
 * Created by Borja on 17/7/17.
 */

class MainPresenter @Inject constructor(val view: MainView, val loginInteractor: LoginInteractor, val exceptionHandler: AndroidExceptionHandler) {


    fun login(email: String, password: String) {

        if (userShouldLogin(email, password)) {

            loginInteractor.execute(LoginInteractor.Parameters(email, password)) { result ->
                result.success { value ->
                    view.navigateToChooseProfile(value)

                }
                result.failure { exception ->
                    exceptionHandler.notifyException(view, exception)
                }
            }
        } else {
            view.showLoginError()
        }

    }

    private fun userShouldLogin(email: String, password: String): Boolean {

        if (email.isEmpty() || password.isEmpty()) {
            return false
        }

        return true
    }
}