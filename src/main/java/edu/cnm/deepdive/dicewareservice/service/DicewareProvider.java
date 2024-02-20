package edu.cnm.deepdive.dicewareservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class DicewareProvider implements PassphraseProvider {

  private final List<String> words;
  private final RandomGenerator rng;

  public DicewareProvider(WordProvider provider, RandomGenerator rng){
    words = new ArrayList<>(provider.words());
    this.rng = rng;
  }
  @Override
  public List<String> generate(int length) {
    return Stream
        .generate(() -> words.get(rng.nextInt(words.size())))
        .limit(length)
        .collect(Collectors.toList());
  }
}
