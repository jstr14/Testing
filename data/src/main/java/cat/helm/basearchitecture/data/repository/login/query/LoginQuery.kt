package cat.helm.basearchitecture.data.repository.login.query

import cat.helm.basearchitecture.data.repository.query.Query

/**
 * Created by Héctor on 15/12/2017.
 */
interface LoginQuery : Query {

    companion object Parameters {
        const val USERNAME = "USERNAME"
        const val PASSWORD = "PASSWORD"
    }
}