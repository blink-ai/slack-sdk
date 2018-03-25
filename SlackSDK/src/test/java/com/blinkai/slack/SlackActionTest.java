package com.blinkai.slack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.blinkai.slack.SlackAction.Style;
import com.blinkai.slack.SlackAction.Type;
import org.junit.Test;

public class SlackActionTest {

  @Test
  public void setters_setsValues() {
    SlackAction action = new SlackAction()
        .text("text")
        .style(Style.PRIMARY)
        .type(Type.BUTTON)
        .url("https://localhost:8080");

    assertNotNull(action);
    assertEquals("text", action.text());
    assertEquals(Style.PRIMARY, action.style());
    assertEquals(Type.BUTTON, action.type());
    assertEquals("https://localhost:8080", action.url());
  }

  @Test
  public void gson_serializesCorrectly() {
    Slack slack = Slack.builder("https://localhost").build();
    SlackAction action = new SlackAction()
        .text("text")
        .style(Style.PRIMARY)
        .type(Type.BUTTON)
        .url("https://localhost:8080");

    assertEquals("{\"type\":\"button\",\"text\":\"text\",\"url\":\"https://localhost:8080\",\"style\":\"primary\"}", slack.getGson().toJson(action));
  }
}
