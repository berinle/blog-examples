package com.objectpartners.blog.dropwizard.guice.resources

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path('/')
class EchoResource {

    HelloWorld helloWorld
    Echo echo

    @Inject
    EchoResource(HelloWorld helloWorld, Echo echo) {
        this.helloWorld = helloWorld
        this.echo = echo
    }

    @GET
    String hello() {
        helloWorld.reponse
    }

    @POST
    @Path('echo/{post}')
    String echo(@PathParam('post') String post) {
        echo.getResponse(post)
    }
}

class HelloWorld {

    String getReponse() {
        'Hello, world!'
    }
}

class Echo {

    String getResponse(String post) {
        post
    }
}
