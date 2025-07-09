package codes.barker.snippr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(SnippetRepository repository) {
        Snippet[] snippets = new Snippet[] {
                new Snippet("Python", "print('Hello, World!')"),
                new Snippet("Python", "def add(a, b):\n    return a + b"),
                new Snippet("Python", "class Circle:\n    def __init__(self, radius):\n        self.radius = radius\n\n    def area(self):\n        return 3.14 * self.radius ** 2"),
                new Snippet("JavaScript", "console.log('Hello, World!');"),
                new Snippet("JavaScript", "function multiply(a, b) {\n    return a * b;\n}"),
                new Snippet("JavaScript", "const square = num => num * num;"),
                new Snippet("Java", "public class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, World!\");\n    }\n}"),
                new Snippet("Java", "public class Rectangle {\n    private int width;\n    private int height;\n\n    public Rectangle(int width, int height) {\n        this.width = width;\n        this.height = height;\n    }\n\n    public int getArea() {\n        return width * height;\n    }\n}"),
        };

        return args -> {
            for (Snippet snippet : snippets) {
                log.info("Preloading {}", repository.save(snippet));
            }
        };
    }
}
