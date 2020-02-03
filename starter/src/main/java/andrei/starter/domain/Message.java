package andrei.starter.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import andrei.starter.domain.util.MessageHelper;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message is too long (more than 2kb)")
    private String text;
    
    @Length(max = 255, message = "Message is too long (more than 255)")
    private String tag;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    
    @ManyToMany
    @JoinTable(
    		name = "message_likes",
    		joinColumns = {@JoinColumn(name = "message_id")},
    		inverseJoinColumns = {@JoinColumn(name = "user_id")}
    		)
    private Set<User> likes = new HashSet<User>();
    
    private String fileName;
    
    public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}

	
   

	public Message() {
    }

    public Message(String text, String tag, User user) {
    	this.author = user;
        this.text = text;
        this.tag = tag;
    }
    
    public String getAuthorName() {
    	return MessageHelper.getAuthorName(author);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
