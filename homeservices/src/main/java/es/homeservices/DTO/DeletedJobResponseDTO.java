package es.homeservices.DTO;

import es.homeservices.models.Job;
import es.homeservices.models.User;

public class DeletedJobResponseDTO {

    private User user;
    private Job deleted;

    public DeletedJobResponseDTO(User user, Job deleted) {
        this.user = user;
        this.deleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getDeleted() {
        return deleted;
    }

    public void setDeleted(Job deleted) {
        this.deleted = deleted;
    }
}