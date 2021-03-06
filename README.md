# Slack Webhook SDK

[![Build Status](https://travis-ci.org/blink-ai/slack-sdk.svg?branch=master)](https://travis-ci.org/blink-ai/slack-sdk)

Slack Webhook SDK allows [sending messages](https://api.slack.com/docs/messages) to Slack.

## Adding it to your project

Add the dependency in your `build.gradle`:

```gradle
dependencies {
    compile 'com.github.blink-ai:slack-sdk:0.0.2'
}
```
OR
```xml
<dependency>
  <groupId>com.github.blink-ai</groupId>
  <artifactId>slack-sdk</artifactId>
  <version>0.0.2</version>
</dependency>
```

To use the latest build from the `master` branch use:

 ```gradle
dependencies {
    compile 'com.github.blink-ai:slack-sdk:latest.integration'
}
```

## Usage

> Send Simple Message

```java
Slack slack = Slack.builder("https://hooks.slack.com/services/id_1/id_2/token")
        .build();

SlackMessage message = new SlackMessage()
        .text("Hello World <@blink-ai> !");

slack.send(message);
```

> Send Message to a particular channel

```java
Slack slack = Slack.builder("https://hooks.slack.com/services/id_1/id_2/token")
        .build();

SlackMessage message = new SlackMessage()
        .text("Hello World <@blink-ai> !")
        .channel("#another-channel");

slack.send(message);
```
