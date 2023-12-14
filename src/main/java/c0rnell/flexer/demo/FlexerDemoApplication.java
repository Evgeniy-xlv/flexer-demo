package c0rnell.flexer.demo;

import c0rnell.flexer.asm.FlexerAttach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "c0rnell.flexer.demo",
                "c0rnell.flexer.query"
        }
)
public class FlexerDemoApplication {

    public static void main(String[] args) throws Exception {
        FlexerAttach.attach();
        SpringApplication.run(FlexerDemoApplication.class, args);
    }

}
