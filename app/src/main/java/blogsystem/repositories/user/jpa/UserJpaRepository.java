package blogsystem.repositories.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import blogsystem.repositories.user.jpa.model.UserJpaModel;

public interface UserJpaRepository extends JpaRepository<UserJpaModel, String> {

}
