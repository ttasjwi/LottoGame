package com.ttasjwi.LottoGame.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoNumber 클래스")
class LottoNumberTest {

    @Nested
    @DisplayName("of 메서드를 호출할 때")
    class When_call_Of_Method {
        @Nested
        @DisplayName("인자로 유효 최솟값(1)보다 작은 값을 사용할 경우")
        class If_an_argument_is_less_than_validMinNumber {
            @Test
            @DisplayName("IllegalArgumentException을 throw한다.")
            void it_throws_exception() {
                int validMinNumber = 1;
                int testNumber = validMinNumber - 1;

                assertThatThrownBy(() -> LottoNumber.of(testNumber))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("인자로 유효 최댓값(45)보다 큰 값을 사용할 경우")
        class If_an_argument_is_greater_than_validMaxNumber {
            @Test
            @DisplayName("IllegalArgumentException을 throw한다.")
            void it_throws_exception() {
                int validMaxNumber = 45;
                int testNumber = validMaxNumber + 1;

                assertThatThrownBy(() -> LottoNumber.of(testNumber))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("인자로 유효 최솟값(1)을 사용할 경우")
        class If_an_argument_is_validMinNumber {
            @Test
            @DisplayName("인자에 해당하는 LottoNumber을 반환한다.")
            void it_returns_LottoNumber() {
                int validMinNumber = 1;

                LottoNumber findLottoNumber = LottoNumber.of(validMinNumber);
                int innerNumber = findLottoNumber.getValue();

                assertThat(innerNumber).isEqualTo(validMinNumber);
            }
        }

        @Nested
        @DisplayName("인자로 유효 최댓값(45)을 사용할 경우")
        class If_an_argument_is_validMaxNumber {
            @Test
            @DisplayName("인자에 해당하는 LottoNumber을 반환한다.")
            void it_returns_lottoNumber() {
                int validMaxNumber = 45;

                LottoNumber findLottoNumber = LottoNumber.of(validMaxNumber);
                int innerNumber = findLottoNumber.getValue();

                assertThat(innerNumber).isEqualTo(validMaxNumber);
            }
        }
    }
}