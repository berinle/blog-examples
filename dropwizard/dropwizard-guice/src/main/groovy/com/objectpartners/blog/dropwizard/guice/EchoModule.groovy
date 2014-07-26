package com.objectpartners.blog.dropwizard.guice

import com.google.inject.AbstractModule
import com.google.inject.Provider
import com.google.inject.name.Names
import com.objectpartners.blog.dropwizard.guice.dao.NoteDAO
import com.yammer.dropwizard.hibernate.HibernateBundle

class EchoModule extends AbstractModule {

    HibernateBundle<EchoConfiguration> hibernate
    HibernateBundle<EchoConfiguration> hibernate2

    @Override
    protected void configure() {
        bind(NoteDAO).annotatedWith(Names.named("noteDao1")).toProvider(new Provider<NoteDAO>() {
            @Override
            NoteDAO get() {
                return new NoteDAO(hibernate.sessionFactory)
            }
        })

        bind(NoteDAO).annotatedWith(Names.named("noteDao2")).toProvider(new Provider<NoteDAO>() {
            @Override
            NoteDAO get() {
                return new NoteDAO(hibernate2.sessionFactory)
            }
        })
    }

}
