package com.desafio.OrangeTalents.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull(message = "Campo e-mail não pode ser nulo")
    @Email(message = "O valor inserido não corresponde a um e-mail exemplo: nome@dominio.com")
    @Column(name = "email", unique = true, nullable = false, length = 30)
    private String email;

    @CPF(message = "O valor inserido não corresponde a um cpf exemplo: 111.222.333-444")
    @NotNull(message = "Campo cpf não pode ser nulo")
    @Column(name = "cpf", unique = true, nullable = false, length = 14)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false, name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateBorn;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vehicle> vehicles;
}