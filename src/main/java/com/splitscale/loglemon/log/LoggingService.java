package com.splitscale.loglemon.log;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

@Service
public class LoggingService {
  private final ConcurrentLinkedQueue<String> logCache = new ConcurrentLinkedQueue<>();

  public void addLog(String message) {
    if (message.isEmpty()) {
      System.out.println("message is empty");
      return;
    }
    logCache.add(message);
  }

  public Stream<String> getLogStream() {
    return logCache.stream();
  }
}
