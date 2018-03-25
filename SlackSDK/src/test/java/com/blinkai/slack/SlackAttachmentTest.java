package com.blinkai.slack;

import static com.blinkai.slack.SlackMarkdownType.FIELDS;
import static com.blinkai.slack.SlackMarkdownType.TEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.Date;
import org.junit.Test;

public class SlackAttachmentTest {

  @Test
  public void setters_setsValues() {
    SlackField slackField = new SlackField();
    slackField.title("Priority");
    slackField.value("High");
    slackField.shorten(false);

    SlackAttachment attachment = new SlackAttachment();
    attachment.fallback("Required plain-text summary of the attachment.")
        .color("#36a64f")
        .pretext("Optional text that appears above the attachment block")
        .authorName("Bobby Tables")
        .authorLink("http://flickr.com/bobby/")
        .authorIcon("http://flickr.com/icons/bobby.jpg")
        .title("Slack API Documentation")
        .titleLink("https://api.slack.com")
        .text("Optional text that appears within the attachment")
        .imageUrl("http://my-website.com/path/to/image.jpg")
        .thumbUrl("http://example.com/path/to/thumb.png")
        .footer("Slack API")
        .footerIcon("https://platform.slack-edge.com/img/default_application_icon.png")
        .timestamp(new Date())
        .fields(Collections.singletonList(slackField));

    assertEquals("Required plain-text summary of the attachment.", attachment.fallback());
    assertEquals("#36a64f", attachment.color());
    assertEquals("Optional text that appears above the attachment block", attachment.pretext());
    assertEquals("Bobby Tables", attachment.authorName());
    assertEquals("http://flickr.com/bobby/", attachment.authorLink());
    assertEquals("http://flickr.com/icons/bobby.jpg", attachment.authorIcon());
    assertEquals("Slack API Documentation", attachment.title());
    assertEquals("https://api.slack.com", attachment.titleLink());
    assertEquals("Optional text that appears within the attachment", attachment.text());
    assertEquals("http://my-website.com/path/to/image.jpg", attachment.imageUrl());
    assertEquals("http://example.com/path/to/thumb.png", attachment.thumbUrl());
    assertEquals("Slack API", attachment.footer());
    assertEquals("https://platform.slack-edge.com/img/default_application_icon.png", attachment.footerIcon());
  }

  @Test
  public void addField_addsField() {
    SlackAttachment attachment = new SlackAttachment();
    SlackField field = new SlackField();

    assertNull(attachment.fields());

    attachment.addField(field);

    assertNotNull(attachment.fields());
    assertEquals(1, attachment.fields().size());
    assertEquals(field, attachment.fields().get(0));
  }

  @Test
  public void addMarkdownIn_addsMarkdownIn() {
    SlackAttachment attachment = new SlackAttachment();

    assertNull(attachment.markdownIn());

    attachment.addMarkdownIn(TEXT);

    assertNotNull(attachment.markdownIn());
    assertEquals(1, attachment.markdownIn().size());
    assertEquals(TEXT, attachment.markdownIn().get(0));
  }

  @Test
  public void gson_serializesCorrectly() {
    SlackAttachment attachment = new SlackAttachment()
        .addMarkdownIn(TEXT)
        .addMarkdownIn(FIELDS);

    Slack slack = Slack.builder("https://localhost").build();

    assertEquals("{\"mrkdwn_in\":[\"text\",\"fields\"]}", slack.getGson().toJson(attachment));
  }

}
