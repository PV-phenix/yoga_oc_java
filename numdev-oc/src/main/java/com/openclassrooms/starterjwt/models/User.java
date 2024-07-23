package com.openclassrooms.starterjwt.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Table(name = "USERS", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
@Data
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = {"id"})
@Builder
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
@ToString
public class User {
	
	public User() {}
	
	public User(String email, String lastName, String firstName, String encode, boolean b) 
	{
		
		this.email=email;
		this.lastName =lastName;
		this.firstName = firstName;
		this.password=encode;
		this.admin=b;
	
	}
	
	public User(Long id,String email, String lastName, String firstName, String encode, boolean b,LocalDateTime createdAt,LocalDateTime updatedAt) 
	{
		this.id=id;
		this.email=email;
		this.lastName =lastName;
		this.firstName = firstName;
		this.password=encode;
		this.admin=b;
		this.createdAt =createdAt;
		this.updatedAt=updatedAt;
	}
	
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NonNull
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NonNull
	  @Size(max = 20)
	  @Column(name = "last_name")
	  private String lastName;

	  @NonNull
	  @Size(max = 20)
	  @Column(name = "first_name")
	  private String firstName;

	  @NonNull
	  @Size(max = 120)
	  private String password;

	  //@NonNull
	  private boolean admin;

	  @CreatedDate
	  @Column(name = "created_at", updatable = false)
	  private LocalDateTime createdAt;

	  @UpdateTimestamp
	  @Column(name = "updated_at")
	  private LocalDateTime updatedAt;
	  
  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



}
