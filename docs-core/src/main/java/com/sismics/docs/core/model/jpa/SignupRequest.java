package com.sismics.docs.core.model.jpa;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_USER_SIGNUP")
public class SignupRequest {
    @Id
    @Column(name = "USR_ID", length = 36)
    private String id;

    @Column(name = "USR_USERNAME", length = 50, nullable = false)
    private String username;

    @Column(name = "USR_EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "USR_MESSAGE")
    private String message;

    @Column(name = "USR_STATUS", length = 16, nullable = false)
    private String status; // PENDING, APPROVED, REJECTED

    @Column(name = "USR_CREATEDATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "USR_REVIEWDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    @Column(name = "USR_REVIEWER", length = 36)
    private String reviewerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }
}
