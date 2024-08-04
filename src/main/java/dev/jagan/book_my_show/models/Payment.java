package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;

    private String referenceNumber;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;
}
