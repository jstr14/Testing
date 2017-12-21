package cat.helm.basearchitecture

import android.support.test.InstrumentationRegistry
import cat.helm.basearchitecture.data.dependencyinjection.DataModule
import cat.helm.basearchitecture.dependencyinjection.application.ApplicationComponent
import cat.helm.basearchitecture.dependencyinjection.application.ApplicationModule
import it.cosenonjaviste.daggermock.DaggerMock
import it.cosenonjaviste.daggermock.DaggerMockRule

/**
 * Created by Héctor on 18/12/2017.
 */
class EspressoDaggerMockRule : DaggerMockRule<ApplicationComponent>(ApplicationComponent::class.java, ApplicationModule(), DataModule()) {

    init {
        set { component -> getApp().applicationComponent = component }
    }
}
    fun espressoDaggerMockRule() = DaggerMock.rule<ApplicationComponent>(ApplicationModule()){
        set { component ->  getApp().applicationComponent = component}
    }

    fun getApp(): BaseApplication = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as BaseApplication

