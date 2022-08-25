package com.example.springinitializer.userInfo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "usersinfo")
public class Users {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer Id;

   @NotNull(message = "Field must not be empty")
   @Size(min=5)
   @Column(nullable = false, unique = true, length = 45, name="Firstname")
   private String firstname;

   @NotNull(message = "Field must not be empty")
   @Size(min=5)
   @Column(nullable = false, unique = true, length = 45, name="Lastname")
   private String lastname;

   @NotNull(message = "Field must not be empty")
   @Size(min=5)
   @Column(nullable = false, unique = true, length = 45, name="Username")
   private String username;

   @NotNull(message = "Field must not be empty")
   @Size(min=5)
   @Column(nullable = false, unique = true, length = 45, name="Password")
   private String password;

   public Users(){
   }
   public Users(String firstname, String lastname, String username, String password) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.username = username;
      this.password = password;
   }

   public Integer getId() {
      return Id;
   }

   public void setId(Integer id) {
      Id = id;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "Users{" +
              "Id=" + Id +
              ", firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              ", username='" + username + '\'' +
              ", password='" + password + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Users users = (Users) o;
      return Objects.equals(Id, users.Id) && Objects.equals(firstname, users.firstname) && Objects.equals(lastname, users.lastname) && Objects.equals(username, users.username) && Objects.equals(password, users.password);
   }

   @Override
   public int hashCode() {
      return Objects.hash(Id, firstname, lastname, username, password);
   }
}
