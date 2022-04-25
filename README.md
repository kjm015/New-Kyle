# New-Kyle
[![Stars](https://img.shields.io/github/stars/kjm015/New-Kyle.svg)](https://github.com/kjm015/New-Kyle/stargazers)
[![CodeFactor](https://www.codefactor.io/repository/github/kjm015/New-Kyle/badge)](https://www.codefactor.io/repository/github/kjm015/New-Kyle) [![Build Status](https://app.travis-ci.com/kjm015/New-Kyle.svg?branch=master)](https://app.travis-ci.com/kjm015/New-Kyle)
[![Discord](https://discordapp.com/api/guilds/242747048707751936/widget.png)](https://discord.gg/mPnEpjb)<br>

Welcome! This project is an open-source [Kotlin](https://github.com/JetBrains/kotlin)-based Discord bot that uses the [JDA](https://github.com/DV8FromTheWorld/JDA) and [Josh Grosh](https://github.com/jagrosh)'s [JDA Utilities](https://github.com/JDA-Applications/JDA-Utilities).

## Introduction
This project is a collaboration between myself and a few of my friends. It is a proof of concept and learning tool for those who wish to learn modern development practices and tools. It was inspired by one of our friends who used to be in our Discord server. The functionality contained within is supposed to emulate his mannerism as closely as possible.

## Build and Deployment Instructions
This application can be run either from the latest published release, built from source, or deployed using docker. The application depends on four environmental variables being set.

| Environment variable | Description        | Example                                                                         |
|----------------------|--------------------|---------------------------------------------------------------------------------|
| `DISCORD_TOKEN`      | [Bot token](https://github.com/reactiflux/discord-irc/wiki/Creating-a-discord-bot-&-getting-a-token#fetching-your-bots-token)          | <sub><sup>DRSdfL2sRBB4d54Rs5DSTp69C4TRAFb1.9aqaVAPiod6Ma5xC6HMwWQ8rvvMA43ATD9Uwkpcq5LVQUw</sup></sub> |
| `DISCORD_OWNER`      | [Owner user id](https://www.howtogeek.com/714348/how-to-enable-or-disable-developer-mode-on-discord/)      | 965407413600764227                                                              |
| `DISCORD_GAME`       | Game               | My Game                                                                         |
| `DISCORD_PREFIX`     | Bot command prefix | !kyle                                                                           |

### Build locally
To build from source and run locally, set the environment variables and run the `bootRun` task using the gradle wrapper script:

<details>
  <summary>Windows</summary>
  
  ```bat
    set DISCORD_TOKEN=your-bot-token-here
    set DISCORD_OWNER=your-discord-id-here
    set DISCORD_GAME=My Game
    set DISCORD_PREFIX=!kyle 
    .\gradlew.bat bootRun
  ```
</details>

<details>
  <summary>Linux</summary>
  
  ```sh
    export DISCORD_TOKEN=your-bot-token-here
    export DISCORD_OWNER=your-discord-id-here
    export DISCORD_GAME=My Game
    export DISCORD_PREFIX='!kyle '
    ./gradlew bootRun
  ```

</details>

## Current State and Future Plans
As it stands, this bot is simply a testbed and learning platform for myself and my friends to get acquainted with modern development tools and APIs. Eventually, I plan on taking the things that were most valuable in this project and moving on to develop a more serious, useful bot for a wider audience.

For now, it is purely for recreation. More updates will be posted as more functionality of the bot becomes available.
