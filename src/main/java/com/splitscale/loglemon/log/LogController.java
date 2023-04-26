package com.splitscale.loglemon.log;

import java.time.Duration;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/api/v1/logger")
public class LogController {
  private final Sinks.Many<String> sink;

  public LogController() {
    this.sink = Sinks.many().multicast().onBackpressureBuffer();
  }

  @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<String> streamData() {
    return sink.asFlux();
  }

  @PostMapping
  public Mono<Void> logMessage(@RequestBody String message) {
    System.out.println(message);
    sink.tryEmitNext(message);
    return Mono.empty();
  }
}
