package cat.helm.basearchitecture.dependencyinjection.application

import android.app.Application
import android.content.Context
import cat.helm.basearchitecture.data.dependencyinjection.DataModule
import cat.helm.basearchitecture.data.dependencyinjection.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Borja on 21/12/16.
 */
@Module(includes = [DataModule::class])
open class ApplicationModule {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(application: Application): Context {
        return application
    }

}