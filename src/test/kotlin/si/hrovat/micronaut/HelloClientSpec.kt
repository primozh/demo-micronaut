package si.hrovat.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import javax.inject.Inject

@Client("/")
interface HelloClient {

    @Get(consumes = [MediaType.TEXT_PLAIN], uri = "/application-info")
    fun applicationInfo(): Single<String>

    @Get("/random")
    fun random(): Flowable<Int>
}

@MicronautTest
class HelloClientSpec {

    @Inject
    lateinit var client: HelloClient

    @Test
    fun testApplicationInfoResponse() {
        assertEquals("Hello World", client.applicationInfo().blockingGet())
    }

    @Test
    fun testRandomInt() {
        val list = client.random().take(5).toList().blockingGet()
        assertEquals(5, list.size)
    }
}