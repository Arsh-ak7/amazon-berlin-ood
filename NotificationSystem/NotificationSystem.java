package NotificationSystem;

/* Design a notification system that can handle different type of requests like SMS, Email */

enum NotificationType {
    SMS, 
    WHATSAPP,
    EMAIL
}

abstract class EmailNotifications {
    int id;
    NotificationType notificationType;
}

public class NotificationSystem {
    
}
