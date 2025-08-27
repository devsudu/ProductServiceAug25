package dev.sudu.productserviceaug25.models;

import lombok.Data;

@Data
public class BaseModel {
    private Long id;
    private Data createdAt;
    private Data modifiedAt;
}
