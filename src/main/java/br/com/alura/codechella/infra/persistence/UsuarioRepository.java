package br.com.alura.codechella.infra.persistence;

import br.com.alura.codechella.infra.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UserEntity, Long> {
}
