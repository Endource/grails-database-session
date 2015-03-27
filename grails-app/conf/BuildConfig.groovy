grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for backwards-compatibility, the docs are checked into gh-pages branch

grails.project.repos.default = "bintray"
grails.project.repos.bintray.url = "https://api.bintray.com/maven/endource/maven/grails-database-session"

// Set these up in your ~/.grails/settings.groovy with your bintray username and API key
//    grails.project.repos.bintray.username = "admin"
//    grails.project.repos.bintray.password = "password"

grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// specify dependency exclusions here; for example, uncomment this to disable ehcache:
		// excludes 'ehcache'
	}
	log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	checksums true // Whether to verify checksums on resolve
	legacyResolve true // whether to do a secondary resolve on plugin installation, not advised but here for backwards compatibility

	repositories {
		inherits true // Whether to inherit repository definitions from plugins

		grailsPlugins()
		grailsHome()
		grailsCentral()

		mavenLocal()
		mavenCentral()

		mavenRepo("https://repo.grails.org/grails/plugins/")

		// uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
		//mavenRepo "http://snapshots.repository.codehaus.org"
		//mavenRepo "http://repository.codehaus.org"
		//mavenRepo "http://download.java.net/maven/2/"
		//mavenRepo "http://repository.jboss.com/maven2/"
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
