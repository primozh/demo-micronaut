package si.hrovat.micronaut

import javax.inject.Singleton

@Singleton
class DemoService {

    fun returnHi() = "Hi!"
}