#### Lucy, a Music Bot.

Lucy is a music bot example for Javacord, using the library, LavaPlayer.
What differs this from the example on Javacord wiki is the usage of a
TrackScheduler which queues tracks.

A TrackScheduler is highly-customizable, one can do anything they wish
with it, for example, use it to notify a user when a next track will start
or some other stuff.

This is merely an example bot, you are to utilize your own mind and creativity
to create something better. This is also the very basic of the basics, and
won't contain stuff like repeating music, etc.

This bot will also use YouTube Search function provided by LavaPlayer,
and will also support URLs at the same time, as seen on the PlayCommand.

#### Requirements

The requirements for this bot to run are:
- Java (JDK 11, or any JDK that has ifPresentOrElse(...))
- A server, or your home computer that can run the bot.

#### Things to take note of.

As YouTube despises Discord Bots, or any application that scrapes their
videos, or website, using the YouTube source can be the cause of your home network
being banned from YouTube, as such, I don't recommend using ANY Music bot, or hosting
on your homeserver.

There are ways to bypass this, for example, YouTube IPv6 Rotator but that requires
an IPv6 /64 block which is still bannable by YouTube, according to my hosting provider,
an IPv6 block costs 4.99 EUR a month (they do provide one for free).
