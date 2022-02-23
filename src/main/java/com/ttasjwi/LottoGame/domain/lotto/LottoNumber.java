package com.ttasjwi.LottoGame.domain.lotto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoNumber {

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_POOL;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public static final LottoNumber MIN_LOTTO_NUMBER;
    public static final LottoNumber MAX_LOTTO_NUMBER;

    static {
        LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                                    .boxed()
                                    .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
        MIN_LOTTO_NUMBER = LOTTO_NUMBER_POOL.get(MIN_VALUE);
        MAX_LOTTO_NUMBER = LOTTO_NUMBER_POOL.get(MAX_VALUE);
    }

    private final int value;

    public static LottoNumber of(int value) {
        LottoNumber lottoNumber = LOTTO_NUMBER_POOL.get(value);
        validateLottoNumberExistence(lottoNumber);
        return lottoNumber;
    }

    private static void validateLottoNumberExistence(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException(String.format("로또 번호의 유효 범위는 %d 이상 %d 이하입니다.", MIN_VALUE, MAX_VALUE));
        }
    }

}
