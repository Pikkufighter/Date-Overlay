package com.dateOverlay;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@PluginDescriptor(
	name = "Date Overlay"
)
public class DateOverlayPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DateOverlayConfig config;

	@Override
	protected void startUp() throws Exception
	{
		var dateFormat = getDateFormat();
		var localDateTime = java.time.LocalDateTime.now();
		var formatter = java.time.format.DateTimeFormatter.ofPattern(dateFormat);
		var string = localDateTime.format(formatter);
		log.info(String.valueOf(string));
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	public String getDateFormat() {
		switch (config.dateTimeFormat())
		{
			case ddMMyyyyHHmmss:
				return "dd-MM-yyyy HH:mm:ss";
			case yyyyMMdd:
				return "yyyy-MM-dd";
			case yyyyMMddHHmmss:
				return "yyyy-MM-dd HH:mm:ss";
			default:
				return "dd-MM-yyyy";
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{

	}

	@Provides
	DateOverlayConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DateOverlayConfig.class);
	}
}
