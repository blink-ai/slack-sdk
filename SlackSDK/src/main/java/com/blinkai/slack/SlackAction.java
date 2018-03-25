package com.blinkai.slack;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class SlackAction {

  private Type type;
  private String text;
  private String url;
  private Style style;

  public enum Type {
    @SerializedName("button")
    BUTTON
  }

  public enum Style {
    @SerializedName("primary")
    PRIMARY,

    @SerializedName("danger")
    DANGER
  }
}
