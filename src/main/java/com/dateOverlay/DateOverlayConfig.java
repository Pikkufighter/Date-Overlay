package com.dateOverlay;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("DateOverlay")
public interface DateOverlayConfig extends Config
{
	@ConfigItem(
			keyName = "showTime",
			name = "Show Time",
			description = "Show hours, minutes and seconds?"
	)
	default boolean showTime()
	{
		return false;
	}

	@ConfigItem(
			keyName = "dateFormat",
			name = "Date Format",
			description = "Which format the date should be shown in"
	)
	default DateTimeFormats dateTimeFormat()
	{
		return DateTimeFormats.ddMMyyyy;
	}

	public static enum DateTimeFormats
	{
		ddMMyyyy,
		yyyyMMdd,
		MMddyyyy
	}
}
