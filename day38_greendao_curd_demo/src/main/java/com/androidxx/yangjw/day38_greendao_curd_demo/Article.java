package com.androidxx.yangjw.day38_greendao_curd_demo;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.
/**
 * Entity mapped to table "ARTICLE".
 */
@Entity(schema = "androidxx")
public class Article {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String title;
    private String content;

    @Generated
    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    @Generated
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
