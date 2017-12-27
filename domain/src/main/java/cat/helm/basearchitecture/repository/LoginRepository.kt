package cat.helm.basearchitecture.repository

import cat.helm.basearchitecture.Result

/**
 * Created by Héctor on 21/12/2017.
 */
open interface LoginRepository {

    fun login(username:String, password:String): Result<String, Exception>
}