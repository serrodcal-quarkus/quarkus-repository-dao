package dev.serrodcal.application.service;

import dev.serrodcal.domain.dto.UserDTO;
import dev.serrodcal.domain.dto.UserSocialMediaDTO;

import java.util.List;

public interface UserSocialMediaService {

    public UserSocialMediaDTO findById(Long id);

    public void createUser(UserDTO dto);

}
