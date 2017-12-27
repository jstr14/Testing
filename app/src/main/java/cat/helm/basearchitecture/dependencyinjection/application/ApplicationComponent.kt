package cat.helm.basearchitecture.dependencyinjection.application

import android.app.Application
import cat.helm.basearchitecture.BaseApplication
import cat.helm.basearchitecture.data.dependencyinjection.DataModule
import cat.helm.basearchitecture.dependencyinjection.activity.ActivityInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Borja on 21/12/16.
 */
@Singleton
@Component(modules = [(ApplicationModule::class), (AndroidInjectionModule::class), (ActivityInjector::class)])
interface ApplicationComponent {

    fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {

        /* These two methods are neccessary for DaggerMock when running instrumentationstests */
         fun applicationModule(applicationModule: ApplicationModule): Builder
         fun dataModule(dataModule: DataModule): Builder

        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}