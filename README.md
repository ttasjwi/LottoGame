
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

    static {
        LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
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
- 한계점 : 내부값을 확인하기 위해서, `getter`를 정의함.

---

## 고민 포인트
- `MIN_LOTTO_NUMBER`, `MAX_LOTTO_NUMBER` : 테스트코드의 작성시 경계값 테스트의 유지보수성을 위해 외부에 노출했는데, 이것이 과연 올바른 방식일까?
  - Honux의 피드백
    - 경계값이 변하는 경우는 요구사항 자체가 변한 경우가 많고, 자주 일어나는 일이기 때문에 구체적인 경계값을 입력해서 테스트해도 됨.
    - 물론 MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER 등을 외부에 공개하는 것은 객체가 객체답지 못 하게 되는 결과를 낳지만, 그것도 시도해볼만한 방식인 것 같다.
    - 피드백을 반영하여, 테스트코드에서는 구체적인 경계값을 작성하였다.

---