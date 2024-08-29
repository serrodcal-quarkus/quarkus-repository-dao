package dev.serrodcal.application.rest;

import dev.serrodcal.application.rest.model.request.NewUserRequest;
import dev.serrodcal.application.rest.model.response.TweetResponse;
import dev.serrodcal.application.rest.model.response.UserSocialMediaResponse;
import dev.serrodcal.application.service.UserSocialMediaService;
import dev.serrodcal.domain.dto.UserDTO;
import dev.serrodcal.domain.dto.UserSocialMediaDTO;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Path("/v1/socials")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserSocialMediaService userSocialMediaService;

    @GET
    @Path("/users/{userId}")
    public UserSocialMediaResponse users(@PathParam("userId") Long userId) {
        UserSocialMediaDTO dto = this.userSocialMediaService.findById(userId);
        return new UserSocialMediaResponse(
                dto.id(),
                dto.username(),
                dto.fullName(),
                dto.email(),
                new ArrayList<>(
                        dto.tweets().stream()
                        .map(i -> new TweetResponse(i.tweetText(), i.dateCreated()))
                        .toList()
                )
        );
    }

    @POST
    @Path("/users")
    @ResponseStatus(201)
    public void create(@Valid NewUserRequest newUserRequest) {
        Log.info("UserResource.create()");
        Log.debug(newUserRequest.toString());

        this.userSocialMediaService.createUser(
            new UserDTO(
                newUserRequest.username(),
                newUserRequest.fullName(),
                newUserRequest.email()
            )
        );
    }

}
