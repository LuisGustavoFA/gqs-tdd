package email;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EmailManagerTest {
    @Test
    public void shouldSendEmailWelcome() {
        ///os 3 A's, Arrange, Action, Assert
        //Arrange
        EmailService mockEmailService = mock(EmailService.class);
        EmailManager emailManager = new EmailManager(mockEmailService);

        //Action
        emailManager.sendEmail("test@gmail.com");

        //Assert
        verify(mockEmailService).sendEmail("test@gmail.com", "bem vindo", "bem vindo ao sistema");
    }
}
