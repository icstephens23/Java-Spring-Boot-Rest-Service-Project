package com.example.messageRestService;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Message {

  private @Id Long id;
  private String message;

  Message() {}

  Message(Long id, String message) {
    this.id = id;
    this.message = message;
  }

  public Long getId() {
    return this.id;
  }

  public String getMessage() {
    return this.message;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Message))
      return false;
    Message message = (Message) o;
    return Objects.equals(this.id, message.id) && Objects.equals(this.message, message.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.message);
  }

  @Override
  public String toString() {
    return "Message{" + "id=" + this.id + ", message='" + this.message + '\'' + '}';
  }
}