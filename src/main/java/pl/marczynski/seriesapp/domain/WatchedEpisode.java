package pl.marczynski.seriesapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

import pl.marczynski.seriesapp.domain.enumeration.Rate;

/**
 * A WatchedEpisode.
 */
@Entity
@Table(name = "watched_episode")
public class WatchedEpisode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate")
    private Rate rate;

    @Size(max = 500)
    @Column(name = "jhi_comment", length = 500)
    private String comment;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private User user;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Episode episode;

    public WatchedEpisode() {
    }

    public WatchedEpisode(Rate rate, String comment, User user, Episode episode) {
        this.rate = rate;
        this.comment = comment;
        this.user = user;
        this.episode = episode;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WatchedEpisode watchedEpisode = (WatchedEpisode) o;
        if (watchedEpisode.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), watchedEpisode.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WatchedEpisode{" +
            "id=" + getId() +
            ", rate='" + getRate() + "'" +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
