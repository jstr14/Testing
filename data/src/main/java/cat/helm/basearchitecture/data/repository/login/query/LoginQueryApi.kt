package cat.helm.basearchitecture.data.repository.login.query

import cat.helm.basearchitecture.Result
import cat.helm.basearchitecture.data.repository.login.model.TokenDataEntity
import cat.helm.ureentool.data.network.ConnectionChecker
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Héctor on 15/12/2017.
 */
class LoginQueryApi @Inject constructor(val retrofit: Retrofit,
                                        val connectionChecker: ConnectionChecker):LoginQuery{

    override fun query(parameters: HashMap<String, *>?, queryable: Any?): Result<*, *> {

       /* if (connectionChecker.thereIsConnectivity()) {

            val username = parameters?.get(LoginQuery.Parameters.USERNAME) as String
            val password = parameters[LoginQuery.Parameters.PASSWORD] as String

            val loginService = retrofit.create(LoginService::class.java)
            val response = loginService.login(username,password).execute()

            if(response.isSuccessful){

                return response.parseResponse<TokenDataEntity>("")
            }

            return Result.Failure()

        }
        return Result.Failure(NetworkException.NoInternetConnection())*/

        return Result.of { TokenDataEntity("token") }
    }


}