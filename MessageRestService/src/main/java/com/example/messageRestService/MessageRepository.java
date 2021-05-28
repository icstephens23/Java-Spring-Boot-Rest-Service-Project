package com.example.messageRestService;

import org.springframework.data.jpa.repository.JpaRepository;

interface MessageItemRepository extends JpaRepository<Message, Long> {

}