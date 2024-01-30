package com.ex5.intellektaspringwebex5.controllers;

import com.ex5.intellektaspringwebex5.models.Message;
import com.ex5.intellektaspringwebex5.models.User;
import com.ex5.intellektaspringwebex5.repositories.MessageRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    private final User user;
    private final MessageRepository messageRepository;

    public MainController(User user, MessageRepository messageRepository) {
        this.user = user;
        this.messageRepository = messageRepository;
    }

//    @GetMapping("/main")
    @GetMapping
    public String getMain() {
        return "main.html";
    }

//    @PostMapping("/main")
    @PostMapping
    public String postMain(@RequestParam String newMessage) {
        messageRepository.insertNewMessage(newMessage, user.getUsername());
        List<Message> messageList = messageRepository.findAllMessages();
        for (Message message : messageList) System.out.println(message);
        return "main.html";
    }

    @PostMapping("/filter")
    public String receiveUsernameMessages(@RequestParam String filter, Model model) {
        List<Message> messageList = messageRepository.findMessagesByUsername(filter);
        model.addAttribute("messages", messageList);
        return "main.html";
    }

}
