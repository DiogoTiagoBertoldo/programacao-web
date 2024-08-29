package com.entitites;

import com.people.Enrollment;
import com.people.Referee;

import java.util.List;

public class verdict {

    private List<Enrollment> enrollments;

    private Referee referee;

    public verdict(List<Enrollment> enrollments, Referee referee) {
        this.enrollments = enrollments;
        this.referee = referee;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
