package rubixCode.rubixCubeProject;

import java.io.File;
import java.util.ArrayList;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;

public class rubixCommands extends ListenerAdapter{
    String prefix = "!";
    RubixCube playingCube = new RubixCube();
    String id = "";
    String id2 = "";
    RestAction<Message> pause;
    MessageChannel channel;
    ArrayList<String> previousCommands = new ArrayList<String>();

    /*public void rotateCubeCall(RubixCube temp, String orientation){
        temp.rotateCube(orientation);
    }

    public void printCubeToFiles(RubixCube temp){
        temp.printCube();
    }*/


    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");
        
        File image = new File("/Users/nicolassaid/Desktop/rubixBotProject/rubixCubeProject/rubixCube.png");

        if(args[0].equals("currentRubixOutput:")){
            id = event.getMessageId();
        }

        if(args[0].equals(prefix + "help")){
            event.getChannel().sendMessage("Commands(From the left side view):\nclockwise:\n\t f: turn the front side\n\t b: turn the back side\n\t r: turn the right side\n\t l: turn the left side\n\t u: turn the top side\n\t d: turn the bottom side\nIf you want to turn counter clockwise, add a \" ' \" to the end of the command.\nOther Commands:\n\t randomize: randomize cube\n\t display: display cube\n\t reset: reset cube\n\t previousCommands: display previous cube rotations.").queue();
        }

        if(args[0].equals(prefix + "randomize")){
            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.randomizeCube();
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }
            id2 = event.getMessageId();
        }

        if(args[0].equals(prefix + "previousCommands")){
            event.getChannel().sendMessage(previousCommands.toString()).queue();
        }

        if(args[0].equalsIgnoreCase(prefix + "display")){
            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "reset")){
            previousCommands = new ArrayList<String>();

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube = new RubixCube();
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "r")){
            previousCommands.add("r");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("r");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "r'")){
            previousCommands.add("r'");
            
            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("r'");
            playingCube.printCube();
            //image = new File("/Users/nicolassaid/Desktop/rubixBotProject/rubixCubeProject/rubixCube.png");

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "f")){
            previousCommands.add("f");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("f");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "f'")){
            previousCommands.add("f'");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("f'");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "u")){
            previousCommands.add("u");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("u");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "u'")){
            previousCommands.add("u'");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("u'");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "l")){
            previousCommands.add("l");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("l");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "l'")){
            previousCommands.add("l'");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("l'");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "b")){
            previousCommands.add("b");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("b");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "b'")){
            previousCommands.add("b'");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("b'");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "d")){
            previousCommands.add("d");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("d");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

        if(args[0].equalsIgnoreCase(prefix + "d'")){
            previousCommands.add("d'");

            if(!id.equals("")){
                event.getChannel().deleteMessageById(id).queue();
                event.getChannel().deleteMessageById(id2).queue();
            }

            playingCube.rotateCube("d'");
            playingCube.printCube();

            try{
                event.getChannel().sendMessage("currentRubixOutput:").addFile(image).queue();
            } catch(Exception e) {
                event.getChannel().sendMessage("currentRubixOutput: Error, Image Not Found").queue();
            }

            id2 = event.getMessageId();
        }

    }
}