package dev.serrodcal.application.rest.mapping;

import jakarta.ws.rs.core.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMappers {

    private record ErrorResponse(String message) { }

    @ServerExceptionMapper
    public Response mapException(ConstraintViolationException ex) {
        return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponse("username or email already exists"))
                .build();
    }

}
