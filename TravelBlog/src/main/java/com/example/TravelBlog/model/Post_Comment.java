package com.example.TravelBlog.model;

        import java.util.Date;

public class Post_Comment {
    private int post_comment_id;
    private int post_id;
    private int parent_id;
    private int published;
    private Date createdAt;
    private Date publishedAt;
    public int getPost_comment_id() {
        return post_comment_id;
    }
}