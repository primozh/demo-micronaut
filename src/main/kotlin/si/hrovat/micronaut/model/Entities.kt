package si.hrovat.micronaut.model

import io.micronaut.core.annotation.Introspected
import javax.inject.Singleton
import kotlin.random.Random

@Introspected data class Conference (val name: String)

@Singleton
class ConferenceService {
    companion object {
        val conferences: List<Conference> = listOf(
            Conference("Greach"),
            Conference("GR8Conf"),
            Conference("MakeIT")
        )
    }

    fun randomConf(): Conference = conferences[Random.Default.nextInt(conferences.size)]
}