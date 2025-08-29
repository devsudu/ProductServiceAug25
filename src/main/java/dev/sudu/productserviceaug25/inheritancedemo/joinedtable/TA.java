package dev.sudu.productserviceaug25.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_tas")
public class TA extends User {
    private int numberOfHrs;
    private Double avgRating;
}
