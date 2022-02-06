package rubixCode.rubixCubeProject;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class rubixCubeRun {
    public static void main(String[] args) throws LoginException{
        JDABuilder jda = JDABuilder.createDefault("OTM5NTY3ODM1MDU3OTAxNTY4.Yf6uvA.Q6e0ABdVzQqrNOtKlEtwkllyOOk");
        jda.setActivity(Activity.playing("Save Me"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new rubixCommands());
        jda.build();
    }
}
