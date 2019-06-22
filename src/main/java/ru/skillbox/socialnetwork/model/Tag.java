package ru.skillbox.socialnetwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * тэги
 */
@Entity
@Table(name = "tag")
public class Tag {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    /**
     * Тэг
     */
    @Column(name = "tag", unique = true)
    private String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
