package com.devshowcase.api.service;

import com.devshowcase.api.dto.request.ProfileRequest;
import com.devshowcase.api.dto.response.ProfileResponse;
import com.devshowcase.api.entity.Profile;
import com.devshowcase.api.exception.ResourceNotFoundException;
import com.devshowcase.api.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileResponse create(ProfileRequest request) {

        Profile profile = new Profile();

        profile.setName(request.getName());
        profile.setBio(request.getBio());
        profile.setGithubUrl(request.getGithubUrl());
        profile.setLinkedinUrl(request.getLinkedinUrl());

        Profile savedProfile = profileRepository.save(profile);

        return new ProfileResponse(
                savedProfile.getId(),
                savedProfile.getName(),
                savedProfile.getBio(),
                savedProfile.getGithubUrl(),
                savedProfile.getLinkedinUrl()
        );
    }

    public ProfileResponse findById(Long id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile não encontrado")
                );

        return new ProfileResponse(
                profile.getId(),
                profile.getName(),
                profile.getBio(),
                profile.getGithubUrl(),
                profile.getLinkedinUrl()
        );
    }
}