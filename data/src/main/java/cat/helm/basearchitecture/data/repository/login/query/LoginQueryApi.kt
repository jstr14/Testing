package cat.helm.basearchitecture.data.repository.login.query

import cat.helm.basearchitecture.Result
import cat.helm.basearchitecture.data.network.ConnectionChecker
import cat.helm.basearchitecture.data.network.parseResponse
import cat.helm.basearchitecture.data.network.service.LoginService
import cat.helm.basearchitecture.model.exceptions.NetworkException
import cat.helm.kindergarden.model.Token
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Héctor on 15/12/2017.
 */
class LoginQueryApi @Inject constructor(val retrofit: Retrofit,
                                        val connectionChecker: ConnectionChecker):LoginQuery{

    override fun query(parameters: HashMap<String, *>?, queryable: Any?): Result<*, *> {

        if (connectionChecker.thereIsConnectivity()) {

            val username = parameters?.get(LoginQuery.Parameters.USERNAME) as String
            val password = parameters[LoginQuery.Parameters.PASSWORD] as String

            val loginService = retrofit.create(LoginService::class.java)
            val response = loginService.login(username,password).execute()

            if(response.isSuccessful){

                return response.parseResponse<Token>("")
            }

            return Result.Failure()

        }
        return Result.Failure(NetworkException.NoInternetConnection())
    }


}