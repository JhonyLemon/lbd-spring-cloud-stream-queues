package pl.fissst.lbd.queues.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fissst.lbd.queues.services.EmailService;

@RestController
@RequestMapping("/emailToUser")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void SendEmailToUser(){
        emailService.SendEmailToUser();
    }

}
