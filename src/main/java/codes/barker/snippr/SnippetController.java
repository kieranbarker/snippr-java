package codes.barker.snippr;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SnippetController {
    private final SnippetRepository repository;

    SnippetController(SnippetRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/snippets")
    ResponseEntity<Snippet> newSnippet(@RequestBody Snippet newSnippet) {
        Snippet savedSnippet = repository.save(newSnippet);
        URI location = URI.create("/snippets/" + savedSnippet.getId());
        return ResponseEntity.created(location).body(savedSnippet);
    }

    @GetMapping("/snippets")
    List<Snippet> all(@RequestParam(required = false) String language) {
        List<Snippet> snippets;

        if (language == null) {
            snippets = repository.findAll();
        } else {
            snippets = repository.findByLanguageIgnoreCase(language);
        }

        return snippets;
    }

    @GetMapping("/snippets/{id}")
    Snippet one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new SnippetNotFoundException(id));
    }
}
