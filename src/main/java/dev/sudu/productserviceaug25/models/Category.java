package dev.sudu.productserviceaug25.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    private String title;
}
