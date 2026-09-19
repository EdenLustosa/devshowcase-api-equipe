package com.devshowcase.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProfileRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    private String bio;

    @Pattern(
            regexp = "https?://.+",
            message = "GitHub URL deve ser uma URL válida"
    )
    private String githubUrl;

    @Pattern(
            regexp = "https?://.+",
            message = "LinkedIn URL deve ser uma URL válida"
    )
    private String linkedinUrl;

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
}