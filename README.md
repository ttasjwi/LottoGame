
# LottoGame

- 로또 게임 구현 (스프링 부트)

---

## LottoNumber
```java
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
```
- 로또 번호를 정의함
- `of` 메서드를 통해 `LottoNumber`를 반환함.
- 만약 유효값에 해당하지 않는 value를 인자로 호출하였을 경우, IllegalArgumentException이 발생함.

---

## 고민 포인트
- `MIN_LOTTO_NUMBER`, `MAX_LOTTO_NUMBER` : 테스트코드의 작성시 경계값 테스트의 유지보수성을 위해 외부에 노출했는데, 이것이 과연 올바른 방식일까?

---