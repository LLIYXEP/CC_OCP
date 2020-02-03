package sarafan.my.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sarafan.my.domain.User;

public interface UserDetailRepo extends JpaRepository<User, String> {

}
