package com.objectpartners.blog.dropwizard.guice

import com.hubspot.dropwizard.guice.GuiceBundle
import com.objectpartners.blog.dropwizard.guice.entities.NoteEntity
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle

class EchoService extends Service<EchoConfiguration> {

    private final HibernateBundle<EchoConfiguration> hibernate = new HibernateBundle<EchoConfiguration>(NoteEntity, [] as Class[]) {

        @Override
        DatabaseConfiguration getDatabaseConfiguration(EchoConfiguration configuration) {
            return configuration.database
        }
    }

    private final HibernateBundle<EchoConfiguration> hibernate2 = new HibernateBundle<EchoConfiguration>(NoteEntity, [] as Class[]) {

        @Override
        DatabaseConfiguration getDatabaseConfiguration(EchoConfiguration configuration) {
            return configuration.database2
        }
    }

    public static void main(String[] args) {
        new EchoService().run(args)
    }

    @Override
    void initialize(Bootstrap<EchoConfiguration> bootstrap) {
        bootstrap.name = 'echo'
        bootstrap.addBundle(hibernate)
        bootstrap.addBundle(hibernate2)
        bootstrap.addBundle(
                GuiceBundle.<EchoConfiguration>newBuilder()
                        .addModule(new EchoModule(hibernate: hibernate, hibernate2: hibernate2))
                        .setConfigClass(EchoConfiguration)
                        .enableAutoConfig(this.class.package.name)
                        .build()
        )
    }

    @Override
    void run(EchoConfiguration configuration, Environment environment) throws Exception {

    }
}
