package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="todo")
public class Todo {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="contents")
    private String contents;

    @Column(name="Date")
    private String Date;

    @Column(name="completed")
    private String completed;


    // 생성자 만들기
    public Todo() {

    }

    public Todo(String title, String contents, String date, String completed) {
        this.title = title;
        this.contents = contents;
        Date = date;
        this.completed = completed;
    }
    //  게터/세터 만들기


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    // toString 만들기

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", Date='" + Date + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}








