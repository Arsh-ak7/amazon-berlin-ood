package NotificationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* Design a notification system that can handle different type of requests like SMS, Email */

enum NotificationType {
    SMS, 
    WHATSAPP,
    EMAIL
}

abstract class Notifications {
    Integer id;
    NotificationType notificationType;
}

class EmailNotification extends Notifications {
    String emailFrom;
    String emailTo;
    String subject;
    String body;

    public EmailNotification(Integer id, String emailFrom, String emailTo, String subject, String body){
        this.id = id;
        this.notificationType = NotificationType.EMAIL;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.body = body;
        this.subject = subject;
    }

    public void handleEmailNotification(EmailNotification emailNotification){

    }
}

class SMSNotification extends Notifications {
    String toNumber;
    String body;

    public SMSNotification(Integer id, String toNumber, String body) {
        this.id = id;
        this.notificationType = NotificationType.SMS;
        this.body = body;
    }

    public void handleSmsNotification(SMSNotification smsNotification){

    }
}

class WhatsappNotification extends Notifications {
    String toNumber;
    String body;

    public WhatsappNotification(Integer id, String toNumber, String body){
        this.id = id;
        this.notificationType = NotificationType.WHATSAPP;
        this.toNumber = toNumber;
        this.body = body;
    }

    public void handleWhatsappNotification(WhatsappNotification whatsappNotification){

    }
}

public class NotificationSystem {
     List<Notifications> list;

    public NotificationSystem(){
        this.list = new ArrayList<Notifications>();
    }

    void processRequests(List<Notifications> list) {
        for(Notifications notif: list){
            if(notif.notificationType == NotificationType.EMAIL){
                EmailNotification emailNotif = new EmailNotification(UUID.randomUUID(), emailFrom, emailTo, subject, body);
                emailNotif.handleEmailNotification(emailNotif);
            }
        }
    }

    public static void main(String args[]){
        NotificationSystem notifSystem = new NotificationSystem();
        // notifSystem.list = getListFrombackend();
        notifSystem.processRequests(notifSystem.list);
    }
}   





