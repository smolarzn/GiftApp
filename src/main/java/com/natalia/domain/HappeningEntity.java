package com.natalia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "happening")
public class HappeningEntity extends AbstractEntity {

    @NotNull
    private String topic;

    @Size(max = 50)
    private String description;

    @NotNull
    @Column(name = "happening_day")
    private LocalDate time;

    @ManyToMany
    @JoinTable(
            name = "happening_to_participant",
            joinColumns = @JoinColumn(name = "happening_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private List<UserEntity> participants;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public List<UserEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserEntity> participants) {
        this.participants = participants;
    }
}
