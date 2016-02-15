package com.dirspy.webservice.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author Victor Moskvych
 */

public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date entryDate;
    private String faculty;
    private String group;
    private int course;

    public Student() {}

    private Student(Builder builder) {

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.entryDate = builder.entryDate;
        this.faculty = builder.faculty;
        this.group = builder.group;
        this.course = builder.course;

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", entryDate=" + entryDate +
                ", faculty='" + faculty + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                '}';
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private Date birthDate;
        private Date entryDate;
        private String faculty;
        private String group;
        private int course;

        private Builder() {}

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder entryDate(Date entryDate) {
            this.entryDate = entryDate;
            return this;
        }

        public Builder faculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder group(String group) {
            this.group = group;
            return this;
        }

        public Builder course(int course) {
            this.course = course;
            return this;
        }

        public Student build() {
            Student build = new Student(this);

            //TODO: add student's data verification

            return build;
        }

    }
}
