package edu.cnm.deepdive.dicewareservice.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ResourceWordListProvider implements WordProvider {

  private final List<String> words;

  public ResourceWordListProvider(@Value("${diceware.word-list}") String wordList) {
    Resource resource = new ClassPathResource(wordList);
    try (Stream<String> lines = Files.lines(Paths.get(resource.getURI()))) {
      words = lines
          .map(String::strip)
          .filter(Predicate.not(String::isEmpty))
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

    @Override
  public List<String> words() {
    return words;
  }
}
