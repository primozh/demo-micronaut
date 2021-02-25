package si.hrovat.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.reactivex.Single
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@Client("/application-info")
interface HelloClient {

    @Get(consumes = [MediaType.TEXT_PLAIN])
    fun applicationInfo(): Single<String>
}


@MicronautTest
class HelloClientSpec {

    @Inject
    lateinit var client: HelloClient

    @Test
    fun testApplicationInfoResponse() {
        assertEquals("Hello World", client.applicationInfo().blockingGet())
    }
}