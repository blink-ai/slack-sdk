package com.blinkai.slack;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum SlackMarkdownType {

  @SerializedName("pretext")
  PRETEXT,

  @SerializedName("text")
  TEXT,

  @SerializedName("fields")
  FIELDS;
}
