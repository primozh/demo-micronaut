package si.hrovat.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("/application-info")
interface HelloClient {

    @Get(consumes = [MediaType.TEXT_PLAIN])
    fun applicationInfo(): Single<String>
}
