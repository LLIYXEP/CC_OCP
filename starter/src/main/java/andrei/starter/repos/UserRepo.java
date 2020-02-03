package andrei.starter.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import andrei.starter.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    User findByActivationCode(String code);

	
}
