package codes.barker.snippr;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Snippet {

    private @Id @GeneratedValue Long id;
    private String language;
    private String code;

    Snippet() {}

    Snippet(String language, String code) {
        this.language = language;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getCode() {
        return this.code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snippet snippet = (Snippet) o;
        return Objects.equals(id, snippet.id) && Objects.equals(language, snippet.language) && Objects.equals(code, snippet.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, code);
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
