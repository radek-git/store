package com.radek.store.entity.users;

import com.radek.store.entity.Position;
import com.radek.store.entity.Store;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Table(name = "employees")
@Entity(name = "Employee")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Employee extends User{

    @Builder
    public Employee(@NonNull String name, @NonNull String surname, @NonNull String username,
                    @NonNull @Email String email, @NonNull String password, @NonNull String phoneNumber,
                    Store store, Position position,  Employee addedBy) {
        super(name, surname, username, email, password, phoneNumber);
        this.store = store;
        this.position = position;
        this.addedBy = addedBy;
    }


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "added_by_employee_id")
    private Employee addedBy;
}
