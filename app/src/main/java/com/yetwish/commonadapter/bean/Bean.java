package com.yetwish.commonadapter.bean;

/**
 * Bean类
 * Created by yetwish on 2015-05-11
 */

public class Bean {
    private String title;
    private String content;
    private String time;
    private String comments;

    public Bean(String title, String content, String time, String comments) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.comments = comments;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
