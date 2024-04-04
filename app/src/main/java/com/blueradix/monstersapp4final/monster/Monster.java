package com.blueradix.monstersapp4final.monster;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "MONSTER")
public class Monster implements Serializable{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    private Integer id;

    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "DESCRIPTION")
    private String description;
    @ColumnInfo(name = "IMAGE")
    private String image;
    @ColumnInfo(name = "SCARINESS")
    private Integer scariness;
    @ColumnInfo(name = "VOTES")
    private Integer votes;
    @ColumnInfo(name = "STARS")
    private Integer stars;

    @Ignore
    public Monster() {
    }

    public Monster(String name, String description, String image, Integer scariness, Integer votes, Integer stars) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.scariness = scariness;
        this.votes = votes;
        this.stars = stars;
    }


    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getScariness() {
        return scariness;
    }

    public void setScariness(Integer scariness) {
        this.scariness = scariness;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @NonNull
    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", scariness=" + scariness +
                ", votes=" + votes +
                ", stars=" + stars +
                '}';
    }
}
