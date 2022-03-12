package dev.janeki.streamsched.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record LiveStream(
  String id,
  @NotEmpty(message = "Stream title is required")
  String title,
  String description,
  String url,
  java.time.LocalDateTime start,
  java.time.LocalDateTime endDate) {

}
