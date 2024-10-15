package lk.ijse.phase02.entity.impl;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.phase02.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String contact;
    private String address;
}
