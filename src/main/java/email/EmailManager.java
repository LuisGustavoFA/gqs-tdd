package email;

public class EmailManager {
    private EmailService emailService;

    public EmailManager(EmailService emailService) {
        this.emailService = emailService;
    }

    void sendEmail(String emailAddress) {
        emailService.sendEmail(emailAddress, "bem vindo", "bem vindo ao sistema");
    }
}
