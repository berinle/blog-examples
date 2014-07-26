package com.objectpartners.blog.dropwizard.guice.service

import com.objectpartners.blog.dropwizard.guice.dao.NoteDAO
import com.objectpartners.blog.dropwizard.guice.entities.NoteEntity

import javax.inject.Inject
import javax.inject.Named

class NoteService {

    NoteDAO noteDAO, noteDAO2

    @Inject
    public NoteService(@Named("noteDao1") NoteDAO noteDAO, @Named("noteDao2") NoteDAO noteDAO2) {
        this.noteDAO = noteDAO
        this.noteDAO2 = noteDAO2
    }

    List<NoteEntity> findAll() {
        noteDAO.list()
    }

    NoteEntity find(Long id) {
        noteDAO.get(id)
    }

    NoteEntity save(String note) {
        noteDAO.save(note)
    }

}
