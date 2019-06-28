package com.radek.store.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDTO implements Serializable {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
