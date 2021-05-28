package com.example.messageRestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  //public Long testId1 = valueOf(1);
  @Bean
  CommandLineRunner initDatabase(MessageItemRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Message(new Long(123), "Hello World")));
      log.info("Preloading " + repository.save(new Message(new Long(57), "Goodbye")));
    };
  }
}