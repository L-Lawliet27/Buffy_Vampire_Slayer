package tp1.commands;

import tp1.exceptions.CommandParseException;

public class CommandGenerator {

    private static Command[] availableCommands = {
            new AddSlayerCommand(),
            new AddBloodBankCommand(),
            new SuperCoinCommand(),
            new ExitCommand(),
            new GarlicPushCommand(),
            new HelpCommand(),
            new LightFlashCommand(),
            new UpdateCommand(),
            new AddVampireCommand(),
            new ResetCommand(),
            new StringifyCommand(),
            new SaveCommand()
    };

    public static Command parseCommand(String[] commandWords) throws CommandParseException {
        for (Command c : availableCommands) {
            Command selected = c.parse(commandWords);
            if(selected != null){
                return selected;
            }
        }
        throw new CommandParseException();
    }

    public static String commandHelp(){

        StringBuilder help = new StringBuilder();
        for (Command c : availableCommands) {
            help.append(c.helpText());
        }

        return help.toString();
    }

}
