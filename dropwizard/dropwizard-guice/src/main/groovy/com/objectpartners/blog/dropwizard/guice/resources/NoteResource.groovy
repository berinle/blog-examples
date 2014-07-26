package com.objectpartners.blog.dropwizard.guice.resources

import com.objectpartners.blog.dropwizard.guice.entities.NoteEntity
import com.objectpartners.blog.dropwizard.guice.service.NoteService
import com.yammer.dropwizard.hibernate.UnitOfWork

import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path('/notes')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class NoteResource {


    NoteService noteService

    @Inject
    public NoteResource(NoteService noteService) {
        this.noteService = noteService
    }

    @GET
    @UnitOfWork
    List<NoteEntity> getNotes() {
        noteService.findAll()
    }

    @POST
    @UnitOfWork
    NoteEntity saveNote(@Valid String text) {
        noteService.save(text)
    }

    @GET
    @Path('{id}')
    @UnitOfWork
    NoteEntity getNote(@PathParam('id') Long id) {
        noteService.find(id)
    }
}
