package cat.helm.basearchitecture.ui.exception

import android.content.Context
import cat.helm.basearchitecture.R
import cat.helm.basearchitecture.data.dependencyinjection.qualifier.ApplicationContext
import cat.helm.basearchitecture.ui.base.BaseView
import cat.helm.ureentool.model.exceptions.NetworkException
import cat.helm.ureentool.ui.base.ExceptionHandler
import dagger.Reusable
import javax.inject.Inject

/**
 * Created by Héctor on 10/10/2017.
 */
@Reusable
class AndroidExceptionHandler @Inject constructor(@ApplicationContext val context: Context) : ExceptionHandler {

    override fun<T: BaseView> notifyException(view: T, exception: Exception?) {
        when (exception) {

            is NetworkException.UnauthorizedException ->  view.showException(context.getString(R.string.unauthorized))
            is NetworkException.NoInternetConnection -> view.showException(context.getString(R.string.no_internet_connection))
            is NetworkException.ServerException -> view.showException(context.getString(R.string.server_error))
            else -> view.showException(exception?.message ?: "Unknown error")

        }
    }
}