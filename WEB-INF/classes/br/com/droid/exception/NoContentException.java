package br.com.droid.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class NoContentException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public NoContentException(String mensagem) {
     super(Response.status(Status.NOT_FOUND).entity(mensagem).build());
    }
    
}