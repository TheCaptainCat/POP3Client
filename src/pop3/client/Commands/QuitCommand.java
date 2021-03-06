package pop3.client.Commands;

import pop3.client.Client;
import pop3.client.Notification;
import pop3.client.NotificationType;

public class QuitCommand extends Command {
    public QuitCommand(Client client) {
        super(client);
    }

    @Override
    public void handleResult(String result) {
        this.error = !result.startsWith("+OK");
        this.client.notifyGUI(
                new Notification(
                        this.error ? NotificationType.QUIT_FAILED : NotificationType.QUIT_OK,
                        null
                )
        );
    }
}
