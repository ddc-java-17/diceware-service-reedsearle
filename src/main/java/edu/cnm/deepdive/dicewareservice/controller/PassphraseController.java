package edu.cnm.deepdive.dicewareservice.controller;

import edu.cnm.deepdive.dicewareservice.service.PassphraseProvider;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PassphraseController {

  private final PassphraseProvider provider;

  public PassphraseController(PassphraseProvider provider) {
    this.provider = provider;
  }

  @GetMapping(path = "/generate", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<String> get(@RequestParam(required = false, defaultValue = "5") int length) {
    return provider.generate(length);
  }

  @GetMapping(path = "/generate", produces = MediaType.TEXT_HTML_VALUE)
  public String get(@RequestParam(required = false, defaultValue = "5") int length, Model model) {
    model.addAttribute("words", get(length));
    return "generate";
  }
}
