package com.masai.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Email {
    @Id
    private int id;
    private String subject;
    private String content;
    private boolean starred=false;

    @OneToOne(cascade = CascadeType.ALL)
    private User to;

    @ManyToOne(cascade = CascadeType.ALL)
    private User from;
}
