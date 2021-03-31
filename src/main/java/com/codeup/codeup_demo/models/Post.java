package com.codeup.codeup_demo.models;



//import com.mysql.cj.protocol.ColumnDefinition;
//
//import javax.persistence.*;
//import javax.xml.crypto.Data;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//public class Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column (nullable = false, length = 255)
//    private String title;
//
//    @Column (columnDefinition = "TEXT", nullable = false)
//    private String body;
//
//    @OneToOne
//    @JoinColumn(name = user_id)
//    private User owner;
//
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ad")
//    private List<Image> images;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "ads_categories",
//            joinColumns = {@JoinColumn(name = "ad_id")},
//            inverseJoinColumns={@JoinColumn(name="cat_id")}
//    )
//    private List<Category> categories;
//
//
//
//
//
//    //    @Column (columnDefinition="created_time datetime default CURRENT_TIMESTAMP null")
////    @Column
//    private Date created_on;
//    private String created_on_string;
//    //
//////    @Column (columnDefinition = "modified_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP")
//    private Date modified_on;
//    private String modified_on_string;
//    //
//    private SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
//
//    public Post(){
//
//    }
//
//    public Post(String title, String body){};
//
//
//
//    public Post(long id, String title, String body) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }
//
//    public Post(long id, String title, String body, Date created_on, Date modified_on) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.created_on = created_on;
//        this.created_on_string = sdf.format(created_on);
//        this.modified_on = modified_on;
//        this.modified_on_string = sdf.format(modified_on);
//    }
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public Date getCreated_on() {
//        return created_on;
//    }
//
//    public void setCreated_on(Date created_on) {
//        this.created_on = created_on;
//        this.created_on_string = sdf.format(created_on);
//    }
//
//    public Date getModified_on() {
//        return modified_on;
//    }
//
//    public void setModified_on(Date modified_on) {
//        this.modified_on = modified_on;
//        this.modified_on_string = sdf.format(modified_on);
//    }
//
//    public String getCreated_on_string() {
//        return created_on_string;
//    }
//
//
//    public String getModified_on_string() {
//        return modified_on_string;
//    }
//
//
//
////    public SimpleDateFormat getSdf() {
////        return sdf;
////    }
//
//
//}

import javax.persistence.*;

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

    public Post(Long id, String title, String body) {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {

    }

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
}