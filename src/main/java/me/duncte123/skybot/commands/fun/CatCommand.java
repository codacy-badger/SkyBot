package me.duncte123.skybot.commands.fun;

import java.net.URL;

import org.json.JSONObject;

import me.duncte123.skybot.Command;
import me.duncte123.skybot.utils.Config;
import me.duncte123.skybot.utils.URLConnectionReader;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CatCommand implements Command {
	
	public final static String help = "here is a cat.";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub;
		
		try {
			String jsonString = URLConnectionReader.getText("http://random.cat/meow");
			JSONObject jsonObject = new JSONObject(jsonString);
			String newJSON = jsonObject.getString("file");
			event.getTextChannel().sendFile(new URL(newJSON).openStream(), "cat_" + System.currentTimeMillis() + ".png", null).queue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return help;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
    return;
	}

}