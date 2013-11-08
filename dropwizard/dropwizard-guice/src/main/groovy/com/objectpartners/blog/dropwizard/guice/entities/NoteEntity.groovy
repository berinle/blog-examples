package com.objectpartners.blog.dropwizard.guice.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name='note')
class NoteEntity {

    @Id
    @GeneratedValue
    Long id

    @Column(name='text', nullable=false)
    String text
}
