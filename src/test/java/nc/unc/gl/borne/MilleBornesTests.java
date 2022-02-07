package nc.unc.gl.borne;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RequiredArgsConstructor
public class MilleBornesTests {
    private final ApplicationContext springContext;

    @Test
    void spring_context_should_start() {
        assertThat(springContext).isNotNull();
    }
}
