package com.objectpartners.blog.dropwizard.guice

import com.google.inject.AbstractModule
import com.google.inject.Provider
import com.yammer.dropwizard.hibernate.HibernateBundle
import org.hibernate.SessionFactory

class EchoModule extends AbstractModule {

    HibernateBundle<EchoConfiguration> hibernate

    @Override
    protected void configure() {
        bind(SessionFactory).toProvider(new Provider<SessionFactory>() {

            @Override
            SessionFactory get() {
                hibernate.sessionFactory
            }
        })
    }

}
