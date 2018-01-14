package com.example.mahe.task_8;

public class Mov {
    public String name;
    public String realname;
    public String team;
    public String firstappearnace;
    public String createdby;
    public String publisher;
    public String imageurl;
    public String bio;

    public Mov(String name, String realname, String team, String firstappearnace, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearnace = firstappearnace;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearnace() {
        return firstappearnace;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}
