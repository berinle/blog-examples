package com.objectpartners.blog.dropwizard.guice.resources

import com.objectpartners.blog.dropwizard.guice.dao.NoteDAO
import com.objectpartners.blog.dropwizard.guice.entities.NoteEntity
import com.yammer.dropwizard.hibernate.UnitOfWork

import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/notes')
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class NoteResource {

    @Inject
    NoteDAO noteDAO

    @GET
    @UnitOfWork
    List<NoteEntity> getNotes() {
        noteDAO.list()
    }

    @POST
    @UnitOfWork
    NoteEntity saveNote(@Valid String text) {
        noteDAO.save(text)
    }

    @GET
    @Path('{id}')
    @UnitOfWork
    NoteEntity getNote(@PathParam('id') Long id) {
        noteDAO.get(id)
    }
}
