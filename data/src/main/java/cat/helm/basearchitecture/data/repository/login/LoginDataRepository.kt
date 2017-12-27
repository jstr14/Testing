package cat.helm.basearchitecture.data.repository.login

import cat.helm.basearchitecture.Result
import cat.helm.basearchitecture.data.repository.login.model.TokenDataEntity
import cat.helm.basearchitecture.data.repository.login.query.LoginQuery
import cat.helm.basearchitecture.repository.LoginRepository
import cat.helm.ureentool.data.repository.Repository
import javax.inject.Inject

/**
 * Created by Héctor on 21/12/2017.
 */
open class LoginDataRepository @Inject constructor(loginApiDataSource: LoginApiDataSource)
    : LoginRepository, Repository<String, TokenDataEntity>() {

    init {
        readableDataSources.add(loginApiDataSource)
    }


    override fun login(username: String, password: String): Result<String, Exception> {

        val params = HashMap<String, Any>()
        params.put(LoginQuery.USERNAME, username)
        params.put(LoginQuery.PASSWORD, password)
        val result = query(LoginQuery::class.java, params)
        return result.map { it -> it.token }

    }

}
