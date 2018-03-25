package com.blinkai.slack;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class SlackAttachment {

  private String fallback;
  private String color;
  private String pretext;
  private String authorName;
  private String authorLink;
  private String authorIcon;
  private String title;
  private String titleLink;
  private String text;
  private List<SlackField> fields;
  private String imageUrl;
  private String thumbUrl;
  private String footer;
  private String footerIcon;
  private List<SlackAction> actions;

  @SerializedName("mrkdwn_in")
  private List<MarkdownType> markdownIn;

  @SerializedName("ts")
  private Long timestamp;

  public SlackAttachment timestamp(Date date) {
    timestamp = date.getTime() / 1000;
    return this;
  }

  public SlackAttachment addField(SlackField field) {
    if (fields == null) {
      fields = new ArrayList<>();
    }
    fields.add(field);
    return this;
  }

  public SlackAttachment addAction(SlackAction action) {
    if (actions == null) {
      actions = new ArrayList<>();
    }
    actions.add(action);
    return this;
  }

  public SlackAttachment addMarkdownIn(MarkdownType markdownType) {
    if (markdownIn == null) {
      markdownIn = new ArrayList<>();
    }

    markdownIn.add(markdownType);
    return this;
  }

  public enum MarkdownType {

    @SerializedName("pretext")
    PRETEXT,

    @SerializedName("text")
    TEXT,

    @SerializedName("fields")
    FIELDS;
  }
}
