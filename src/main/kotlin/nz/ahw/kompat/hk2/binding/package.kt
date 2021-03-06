/*-----------------------------------------------------*\
**                                                     **
**        kompat-hk2: Kompatibility for HK2            **
**        Kotlin Compatibility Project (Kompat)        **
**        Copyright 2017-2018, Alex Westphal           **
**        https://github.com/ahwnz/kompat-hk2          **
**                                                     **
\*-----------------------------------------------------*/
package nz.ahw.kompat.hk2.binding

import org.glassfish.hk2.api.Factory

fun binder(body: AbstractBinder.() -> Unit): AbstractBinder = object: AbstractBinder() {
    override fun configure() {
        body.invoke(this)
    }
}

fun <T> factory(provide: () -> T): Factory<T> = object: Factory<T> {

    override fun provide(): T = provide()

    override fun dispose(instance: T) {}
}