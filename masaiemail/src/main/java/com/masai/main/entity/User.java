package com.masai.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "email")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
@jakarta.validation.constraints.Email
    private String email;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "write in correct format")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "write in correct format")
    private String lastName;
    @Size(min = 10,max = 10,message = "Mobile number must have 10 digits")
    private String mobileNumber;
    @Past(message = "The date of birth should not be a future date")
    private LocalDate dateOfBirth;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "from")
    @JsonIgnore
    private List<Email> sendMails;

}
