grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for backwards-compatibility, the docs are checked into gh-pages branch

grails.project.repos.default = "bintray"
grails.project.repos.bintray.url = "https://api.bintray.com/maven/endource/maven/grails-database-session"

// Set these up in your ~/.grails/settings.groovy with your bintray username and API key
//    grails.project.repos.bintray.username = "admin"
//    grails.project.repos.bintray.password = "password"

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
	}

	plugins {

		runtime ":hibernate:$grailsVersion", {
			export = false
		}

		build(':release:2.2.1', ':rest-client-builder:1.0.3') {
			export = false
		}
	}
}
