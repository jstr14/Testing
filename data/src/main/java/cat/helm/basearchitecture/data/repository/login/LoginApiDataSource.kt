package cat.helm.basearchitecture.data.repository.login

import cat.helm.basearchitecture.data.dependencyinjection.qualifier.queries.LoginApiQuery
import cat.helm.basearchitecture.data.repository.datasource.ReadableDataSource
import cat.helm.basearchitecture.data.repository.login.model.TokenDataEntity
import cat.helm.basearchitecture.data.repository.query.Query
import javax.inject.Inject

/**
 * Created by Héctor on 15/12/2017.
 */
class LoginApiDataSource @Inject constructor(@LoginApiQuery override val queries: MutableSet<Query>)
    : ReadableDataSource<String, TokenDataEntity>