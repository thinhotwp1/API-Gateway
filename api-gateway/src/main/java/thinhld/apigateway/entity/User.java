package thinhld.apigateway.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
//@Table
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;
    private int age;
}