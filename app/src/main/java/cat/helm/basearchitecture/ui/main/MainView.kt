package cat.helm.basearchitecture.ui.main

import cat.helm.basearchitecture.ui.base.BaseView

/**
 * Created by Borja on 17/7/17.
 */

interface MainView: BaseView{
    fun showLoginError()
    fun navigateToChooseProfile(value: String)

}