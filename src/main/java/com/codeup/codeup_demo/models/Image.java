package com.codeup.codeup_demo.models;

import javax.persistence.*;

@Entity
@Table(name ="images" )
public class Image {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Image(Long id, String path, Post post) {
        this.id = id;
        this.path = path;
        this.post = post;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setAd(Post post) {
        this.post = post;
    }
}
