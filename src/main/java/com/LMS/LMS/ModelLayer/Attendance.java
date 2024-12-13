package com.LMS.LMS.ModelLayer;
import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Lesson lesson;

    private boolean attend;

    public Attendance(Integer id, User student, Lesson lesson, boolean attend) {
        this.id = id;
        this.student = student;
        this.lesson = lesson;
        this.attend = attend;
    }

    public Attendance() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }
}