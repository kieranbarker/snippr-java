package codes.barker.snippr;

class SnippetNotFoundException extends RuntimeException {
    SnippetNotFoundException(Long id) {
        super("Could not find snippet " + id);
    }
}
