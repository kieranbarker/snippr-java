package codes.barker.snippr;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static codes.barker.snippr.Encryptor.decrypt;
import static codes.barker.snippr.Encryptor.encrypt;

@RestController
class SnippetController {
    private final SnippetRepository repository;

    SnippetController(SnippetRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/snippets")
    ResponseEntity<Snippet> newSnippet(@RequestBody Snippet newSnippet) {
        // Encrypt the snippet before storing it in the database
        newSnippet.setCode(encrypt(newSnippet.getCode()));

        Snippet savedSnippet = repository.save(newSnippet);

        // Decrypt the snippet before responding to the client
        savedSnippet.setCode(decrypt(savedSnippet.getCode()));

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

        for (Snippet snippet : snippets) {
            snippet.setCode(decrypt(snippet.getCode()));
        }

        return snippets;
    }

    @GetMapping("/snippets/{id}")
    Snippet one(@PathVariable Long id) {
        Snippet snippet = repository.findById(id).orElseThrow(() -> new SnippetNotFoundException(id));
        snippet.setCode(decrypt(snippet.getCode()));
        return snippet;
    }
}
