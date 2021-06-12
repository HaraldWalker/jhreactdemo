package eu.bitwalker.jhreactdemo.repository;

import eu.bitwalker.jhreactdemo.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
