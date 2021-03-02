package si.hrovat.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import si.hrovat.micronaut.model.Conference
import si.hrovat.micronaut.model.ConferenceService
import javax.inject.Inject

@Controller("/conferences")
class ConferencesController @Inject constructor(val conferenceService: ConferenceService) {

    @Get("/random")
    fun randomConference(): Conference = conferenceService.randomConf()
}