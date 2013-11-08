package com.objectpartners.blog.dropwizard.guice.dao

import com.objectpartners.blog.dropwizard.guice.entities.NoteEntity
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions

import javax.inject.Inject

class NoteDAO extends AbstractDAO<NoteEntity> {

    @Inject
    NoteDAO(SessionFactory sessionFactory) {
        super(sessionFactory)
    }

    List<NoteEntity> list() {
        list(criteria())
    }

    NoteEntity get(Long id) {
        uniqueResult(criteria().add(Restrictions.idEq(id)))
    }

    NoteEntity save(String note) {
        persist(new NoteEntity(text: note))
    }
}
