package si.hrovat.micronaut

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("si.hrovat.micronaut")
		.start()
}