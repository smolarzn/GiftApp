package com.natalia.domain;

import javax.persistence.*;

@Entity
@Table(name = "gift")
public class GiftEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "from_who_id", referencedColumnName = "id")
    private UserEntity fromWho;

    @ManyToOne
    @JoinColumn(name = "to_who_id", referencedColumnName = "id")
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
