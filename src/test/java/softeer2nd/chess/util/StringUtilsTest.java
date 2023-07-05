package softeer2nd.chess.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    @DisplayName("문자열을 줄바꿈한다.")
    public void appendNewLine() {
        String str = "test";
        assertThat(StringUtils.appendNewLine(str)).isEqualTo("test"+StringUtils.NEWLINE);
    }
}