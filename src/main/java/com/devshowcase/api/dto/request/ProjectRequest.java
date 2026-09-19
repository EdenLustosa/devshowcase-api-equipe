package com.devshowcase.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class ProjectRequest {

    @NotBlank(message = "Título é obrigatório")
    private String title;

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotBlank(message = "URL do repositório é obrigatória")
    @Pattern(
            regexp = "https?://.+",
            message = "URL do repositório deve ser válida"
    )
    private String repositoryUrl;

    @Pattern(
            regexp = "https?://.+",
            message = "URL da demonstração deve ser válida"
    )
    private String demoUrl;

    @NotNull(message = "Profile ID é obrigatório")
    private Long profileId;

    private List<Long> technologyIds;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public Long getProfileId() {
        return profileId;
    }

    public List<Long> getTechnologyIds() {
        return technologyIds;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public void setTechnologyIds(List<Long> technologyIds) {
        this.technologyIds = technologyIds;
    }
}
