package ru.pearx.botico.commands;

import ru.pearx.botico.model.*;

/*
 * Created by mrAppleXZ on 11.08.17 16:03.
 */

public class CommandWho extends CommandImpl
{
    public CommandWho()
    {
        super("command.who.names", "command.who.desc");
    }

    @Override
    public BResponse use(BArgs args)
    {
        if(args.isInGroupChat())
        {
            String end = args.getArgumentsJoined().substring(args.getArgumentsJoined().length() - 1);
            return new BResponse(args.getI18n().format("command.who.text", args.getBotico().createMention(args.getRandomGroupChatMember()), end.matches("\\p{P}") ? args.getArgumentsJoined().substring(0, args.getArgumentsJoined().length() - 1) : args.getArgumentsJoined()));
        }
        return new BResponse(args.getI18n().format("command.who.notInGroupChat"));
    }
}
