package cat.helm.basearchitecture.login

import cat.helm.basearchitecture.Result
import cat.helm.basearchitecture.interactor.Interactor
import cat.helm.basearchitecture.repository.LoginRepository
import javax.inject.Inject

/**
 * Created by Héctor on 21/12/2017.
 */
class LoginInteractor @Inject constructor(val repository: LoginRepository)
    : Interactor<String, LoginInteractor.Parameters>() {

    override fun run(params: Parameters): Result<String, *> {
        return repository.login(params.email,params.password)
    }

    data class Parameters(val email: String, val password: String)
}