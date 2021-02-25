package si.hrovat.micronaut

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloClientSpec {

    @Inject
    lateinit var client: HelloClient

    @Test
    fun testApplicationInfoResponse() {
        assertEquals("Hello World", client.applicationInfo().blockingGet())
    }
}