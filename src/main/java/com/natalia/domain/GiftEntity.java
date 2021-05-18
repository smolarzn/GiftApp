package com.natalia.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gift")
public class GiftEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity fromWho;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity toWho;

    @ManyToOne
    @JoinColumn(name = "happening_id")
    private HappeningEntity happening;

    public UserEntity getFromWho() {
        return fromWho;
    }

    public void setFromWho(UserEntity fromWho) {
        this.fromWho = fromWho;
    }

    public UserEntity getToWho() {
        return toWho;
    }

    public void setToWho(UserEntity toWho) {
        this.toWho = toWho;
    }

    public HappeningEntity getHappening() {
        return happening;
    }

    public void setHappening(HappeningEntity happening) {
        this.happening = happening;
    }
}
