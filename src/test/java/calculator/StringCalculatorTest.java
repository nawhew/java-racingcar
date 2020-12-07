package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("입력 값을 받아서 덧셈을 수행하여 값을 리턴 받음")
    @CsvSource(value = {"2 + 3,5", "2 + 3 + 5,10"})
    public void add(String input, String expected) {
        // give
        StringCalculator stringCalculator = new StringCalculator(input);

        // when then
        assertThat(stringCalculator.calculate()).isEqualTo(Integer.parseInt(expected));
    }
}
