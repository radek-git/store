package com.radek.store.entity.users;


import com.radek.store.entity.AbstractEntity;
import com.radek.store.entity.Role;
import com.radek.store.entity.Store;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence")
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    @Email
    @Column(unique = true)
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String phoneNumber;




    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "is_expired")
    private boolean expired;

    @Column(name = "is_locked")
    private boolean locked;

    @Column(name = "is_credentials_expired")
    private boolean credentialsExpired;

    @Column(name = "is_enabled")
    private boolean enabled;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
