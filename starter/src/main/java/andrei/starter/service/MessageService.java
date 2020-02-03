package andrei.starter.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import andrei.starter.domain.Message;
import andrei.starter.domain.User;
import andrei.starter.repos.MessageRepo;

@Service
public class MessageService {
	@Autowired
	private EntityManager em;

	@Autowired
	private MessageRepo messageRepo;
	
	public Page<Message> messageList(Pageable pageable, String filter) {
		if (filter != null && !filter.isEmpty()) {
        	return messageRepo.findByTag(filter, pageable);
        } else {
        	return messageRepo.findAll(pageable);
        }
	}

	public Page<Message> messageListForUser(Pageable pageable, User currentUser, User author) {
		return messageRepo.findByUser(pageable, author);
	}
	
}
