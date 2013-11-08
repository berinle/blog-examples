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

    public static void main(String[] args) {
        new EchoService().run(args)
    }

    @Override
    void initialize(Bootstrap<EchoConfiguration> bootstrap) {
        bootstrap.name = 'echo'
        bootstrap.addBundle(hibernate)
        bootstrap.addBundle(
                GuiceBundle.<EchoConfiguration>newBuilder()
                        .addModule(new EchoModule(hibernate: hibernate))
                        .setConfigClass(EchoConfiguration)
                        .enableAutoConfig(this.class.package.name)
                        .build()
        )
    }

    @Override
    void run(EchoConfiguration configuration, Environment environment) throws Exception {

    }
}
