package model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    private String id;

    @DBRef
    @NotNull
    private Customer customer;

    @DBRef
    @NotNull
    private Restaurant restaurant;

    @NotNull
    private LocalDateTime date;

    private int quantity;

    private String status;

}
