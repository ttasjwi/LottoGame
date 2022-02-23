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
        @DisplayName("인자로 유효 범위보다 작은 값을 사용할 경우")
        class If_an_argument_is_less_than_min_lottoNumber {
            @Test
            @DisplayName("IllegalArgumentException을 throw한다.")
            void it_throws_exception() {
                int number = LottoNumber.MIN_LOTTO_NUMBER.getValue() - 1;

                assertThatThrownBy(() -> LottoNumber.of(number))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("인자로 유효 범위보다 큰 값을 사용할 경우")
        class If_an_argument_is_greater_than_max_lottoNumber {
            @Test
            @DisplayName("IllegalArgumentException을 throw한다.")
            void it_throws_exception() {
                int number = LottoNumber.MAX_LOTTO_NUMBER.getValue() + 1;

                assertThatThrownBy(() -> LottoNumber.of(number))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("인자로 유효 범위의 최솟값을 사용할 경우")
        class If_an_argument_is_MIN_LottoNumber {
            @Test
            @DisplayName("인자에 해당하는 LottoNumber을 반환한다.")
            void it_returns_LottoNumber() {
                int number = LottoNumber.MIN_LOTTO_NUMBER.getValue();

                LottoNumber findLottoNumber = LottoNumber.of(number);
                int innerNumber = findLottoNumber.getValue();

                assertThat(innerNumber).isEqualTo(number);
            }
        }

        @Nested
        @DisplayName("인자로 유효 범위의 최댓값을 사용할 경우")
        class If_an_argument_is_MAX_LottoNumber {
            @Test
            @DisplayName("인자에 해당하는 LottoNumber을 반환한다.")
            void it_returns_lottoNumber() {
                int number = LottoNumber.MAX_LOTTO_NUMBER.getValue();

                LottoNumber findLottoNumber = LottoNumber.of(number);
                int innerNumber = findLottoNumber.getValue();

                assertThat(innerNumber).isEqualTo(number);
            }
        }
    }
}