package sarafan.my.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sarafan.my.domain.Message;


public interface MessageRepo extends JpaRepository<Message, Long> {
}
