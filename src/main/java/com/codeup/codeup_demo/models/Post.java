package com.codeup.codeup_demo.models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name ="posts" )
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 225, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", length = 3000, nullable = false)
    private String body;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User owner;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Image> images;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


public List<Image> getImages() {
            return images;
 }

public void setImages(List<Image> images) {
            this.images = images;
 }
}

