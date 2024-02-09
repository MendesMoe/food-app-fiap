package model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;

    private String firstname;

    @NotNull
    @NotEmpty(message = "The lastname is mandatory")
    private String lastname;

    @NotNull
    @NotEmpty(message = "The city is mandatory")
    private String city;
}