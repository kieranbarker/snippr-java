package codes.barker.snippr;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SnippetRepository extends JpaRepository<Snippet, Long> {
    List<Snippet> findByLanguageIgnoreCase(String language);
}
