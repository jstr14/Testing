package cat.helm.basearchitecture.ui.main

import cat.helm.basearchitecture.R
import cat.helm.basearchitecture.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject lateinit var presenter: MainPresenter

    override fun onRequestLayout(): Int = R.layout.activity_main


    override fun onViewLoaded() {

        loginButton.setOnClickListener{

            presenter.login(username.text.toString(),password.text.toString())
        }
    }

    override fun navigateToChooseProfile(value: String) {
        longToast("token: "+ value)
    }

    override fun showLoginError() {
        longToast("Email and password should be filled")
    }
}
