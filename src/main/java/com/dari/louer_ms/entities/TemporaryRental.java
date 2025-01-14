package com.dari.louer_ms.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class TemporaryRental {
    @Id
    private String rentalId;
    private String propertyId;
    private String startDate;
    private String endDate;
    private double price;

    public TemporaryRental(String rentalId, String propertyId, String startDate, String endDate, double price) {
        this.rentalId = rentalId;
        this.propertyId = propertyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public TemporaryRental() {
    }
}
