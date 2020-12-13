package tp1.commands;

public class CommandGenerator {

    private static Command[] availableCommands = {
            new AddSlayerCommand(),
            new GarlicPushCommand(),
            new LightFlashCommand(),
            new AddVampireCommand(),
            new AddBloodBankCommand(),
            new HelpCommand(),
            new ResetCommand(),
            new ExitCommand(),
            new UpdateCommand(),
            new SuperCoinCommand()
    };

    public static Command parseCommand(String[] commandWords){
        for (Command c : availableCommands) {
            Command selected = c.parse(commandWords);
            if(selected != null){
                return selected;
            }
        }
        return null;
    }

    public static String commandHelp(){

        String help = "";
        for (Command c : availableCommands) {
            help = help + c.helpText();
        }

        return help;
    }

}
