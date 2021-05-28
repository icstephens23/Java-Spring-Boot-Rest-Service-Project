package com.example.messageRestService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MessageController {

  private final MessageItemRepository repository;

  MessageController(MessageItemRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/messages")
  List<Message> all() {
    return repository.findAll();
  }

  // end::get-aggregate-root[]
  @GetMapping("/messages/{id}")
  Message one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new MessageNotFoundException(id));
  }

  @GetMapping("/messages/count")
  int count() {
    int wordCount = 0;
    for(int i = 0; i < repository.count(); i ++){
      String a = repository.findAll().get(i).getMessage();
      for(int j = 0; j < a.length(); j++){
        if(a.charAt(j) == ' '){
          wordCount += 1;
        }
      }
      wordCount += 1;
    }
    return wordCount;
  }


  @PostMapping(value="/messages", produces = "application/json")
  Message newMessage(@RequestBody Message newMessage) {
    return repository.save(newMessage);
  }

  // Single item
  
  

  @PutMapping("/messages/{id}")
  Message replaceEmployee(@RequestBody Message newMessage, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(message -> {
        message.setMessage(newMessage.getMessage());
        message.setId(newMessage.getId());
        return repository.save(message);
      })
      .orElseGet(() -> {
        newMessage.setId(id);
        return repository.save(newMessage);
      });
  }

  @DeleteMapping("/messages/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}