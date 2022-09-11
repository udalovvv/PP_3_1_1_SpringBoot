package web.SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.SpringBoot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
