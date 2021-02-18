package com.zup.cqc.entity.author.response;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuthorResponse {

    private long id;
    private String name;
    private String email;
    private String description;
    private LocalDateTime registerDate;

    public AuthorResponse(long id, String name, String email, String description, LocalDateTime registerDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.registerDate = registerDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }
}
