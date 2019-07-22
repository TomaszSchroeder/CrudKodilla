package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";


    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private TaskRepository taskRepository;

    long size = taskRepository.count();

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(fixedDelay = 20000)
    //@Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        simpleMailService.send(new Mail(
                adminConfig.getAdminMail(),
                "",
                SUBJECT,
                "Currently in database you got: " + size + tasksQuantity()
        ));
    }

    public String tasksQuantity() {
        String oneTask = " task";
        String moreTasks = " tasks";
        return size == 1 ? oneTask : moreTasks;
    }
}
