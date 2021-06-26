package com.desafio.OrangeTalents.repository;

import com.desafio.OrangeTalents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u join fetch u.vehicles where u.cpf = ?1")
    User findByCpfAndVehicle(String cpf);

    User findByCpf(String cpf);
}
