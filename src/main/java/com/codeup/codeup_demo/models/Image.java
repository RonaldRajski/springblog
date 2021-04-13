package com.codeup.codeup_demo.models;

import javax.persistence.*;

@Entity
@Table(name ="images" )
public class Image {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Image(Long id, String url, Post post) {
        this.id = id;
        this.url = url;
        this.post = post;
    }

    public Image() {
    }

    public Image(String url){
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
