package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.User;
import io.github.TaNaLista.tanalista.Model.ENUM.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByCpf(String cpf);

    Optional<User> findByPhone(String phone);

    List<User> findByUserType(UserType userType);

    List<User> findByNameContainingIgnoreCase(String name);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    boolean existsByPhone(String phone);
}