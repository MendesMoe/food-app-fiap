package model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    private String id;

    @NotNull
    @NotEmpty(message = "The name is mandatory")
    private String name;

    @NotNull
    @NotEmpty(message = "The city is mandatory")
    private String city;

    private String foodType;

    @Builder.Default()
    private Boolean open = true;

    @Builder.Default()
    private int stars = 0;
}
