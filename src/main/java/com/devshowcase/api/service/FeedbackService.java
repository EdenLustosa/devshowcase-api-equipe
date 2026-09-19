package com.devshowcase.api.service;

import com.devshowcase.api.dto.request.FeedbackRequest;
import com.devshowcase.api.dto.response.FeedbackResponse;
import com.devshowcase.api.entity.Feedback;
import com.devshowcase.api.entity.Project;
import com.devshowcase.api.repository.FeedbackRepository;
import com.devshowcase.api.repository.ProjectRepository;
import com.devshowcase.api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ProjectRepository projectRepository;

    public FeedbackService(
            FeedbackRepository feedbackRepository,
            ProjectRepository projectRepository
    ) {
        this.feedbackRepository = feedbackRepository;
        this.projectRepository = projectRepository;
    }

    @Transactional
    public FeedbackResponse create(Long projectId, FeedbackRequest request) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Projeto não encontrado")
                );

        Feedback feedback = new Feedback();

        feedback.setRating(request.getRating());
        feedback.setComment(request.getComment());
        feedback.setProject(project);

        Feedback savedFeedback = feedbackRepository.save(feedback);

        Double averageRating =
                feedbackRepository.calculateAverageRating(projectId);

        project.setRatingAverage(averageRating);
        projectRepository.save(project);

        return new FeedbackResponse(
                savedFeedback.getId(),
                savedFeedback.getRating(),
                savedFeedback.getComment(),
                savedFeedback.getProject().getId()
        );
    }
}