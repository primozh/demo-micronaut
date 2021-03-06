package si.hrovat.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@Controller
class HelloController @Inject constructor(val service: DemoService) {

    @Get("/application-info")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String = service.returnHi()

    @Get("/random")
    fun randomNumber(): Flowable<Int> =
        Flowable.interval(1, TimeUnit.SECONDS)
            .map { (Math.random() * 4000).toInt() }
}