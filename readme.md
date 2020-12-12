## Lucy, a Music Bot.
An example of how to implement LavaPlayer with Javacord (including TrackScheduler).

## Information

What differs this from the example on Javacord wiki is the usage of a
`TrackScheduler` which queues tracks, etc.

As you may know, there is already an example of how to use LavaPlayer with Javacord on
the [official wiki of Javacord](https://javacord.org/wiki/) but there is one that isn't
included in their example, and that is the usage of TrackScheduler.

`TrackScheduler`, to simplify things is a highly-customizable class that allows queueing of music,
looping of music and some other stuff like notifying the server that the next track will start or
some other stuff.

It is a very handy implementation to have, and as the ability to use Music is still brand-new in Javacord,
there isn't much who knows how to use the function which is why I decided to create this example, or demonstration
to be exact.

You may copy it, edit it and improve it to your liking, this will merely serve as a demonstration on how to implement it,
please note that this isn't developed by an member, or contributor of Javacord but an external entity.

This is merely an example bot, you are to utilize your own mind and creativity
to create something better. This is also the very basic of the basics, and
won't contain stuff like repeating music, etc.


## What are demonstrated.

* The usage of YouTube search which is provided by LavaPlayer.
* Track Queue.
* Track Skipping.
* Leaving voice channels.
* Track stop.


## Requirements
* Java (JDK 11 or above).
* A server, or your home computer that can run the bot.

## Notice

As YouTube despises Discord Bots, or any application that scrapes their
videos, or website, using the YouTube source can be the cause of your home network
being banned from YouTube, as such, I don't recommend running ANY Music bot, or hosting
on your homeserver.

There are ways to bypass this, for example, YouTube IPv6 Rotator but that requires
an IPv6 /64 block which is still bannable by YouTube, according to my hosting provider,
an IPv6 block costs 4.99 EUR a month (they do provide one for free).

You may find more information about the IPv6 rotator on JDA's official server, whilst for anything
related to Javacord, you may head to the official Javacord server and ask there.

[![JDA guild](https://discordapp.com/api/guilds/125227483518861312/embed.png?style=banner2)](https://discord.gg/jtAWrzU)
[![Javacord Server](https://discordapp.com/api/guilds/151037561152733184/embed.png?style=banner2)](https://discord.gg/0qJ2jjyneLEgG7y3)
