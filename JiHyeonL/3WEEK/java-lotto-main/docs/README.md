기능 요약
---
1. `로또 구매`
    - 로또 구입 금액을 입력받음
    - 1000원(1장 가격) * n개
2. `로또 발행`
    - 로또 구입 개수만큼 발행(n개)
    - 숫자 범위 1~45 에서 랜덤
    - 중복되지 않는 숫자 6개
3. `로또 당첨번호 작성`
    - 유저에게 쉼표로 구분되는 중복되지 않는 숫자 6개 입력받음
    - 보너스 번호 입력받음
4. `로또 당첨 여부 계산한 뒤 출력`
    - 1등: 6개 번호 일치: 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치: 30,000,000원
    - 3등: 4개 번호 일치: 1,500,000원
    - 4등: 4개 번호 일치: 50,000원
    - 5등: 3개 번호 일치: 5,000원
5. `수익률 계산 후 출력`
    - 소수점 둘째 자리에서 반올림

패키지 분리
---
**📂 controller** : 들어온 요청에 맞게 서비스를 호출하고, 서비스에 의해 로직이 처리된 model 결과를 view에 전달한다.
- LottoGame 클래스: 

**📂 domain** : DB 객체
- BonusLotto 클래스
  - 보너스 번호 객체
  - Exception 클래스를 거쳐 예외가 발생하지 않는지 확인하는 validation 메소드가 있다.
- Lotto 클래스: 로또 당첨 번호 객체. validation 메소드가 있다.
- Pay 클래스: 로또 구입 금액 객체. validation 메소드가 있다.
- RandomLotto 클래스: 하나의 랜덤 생성 로또 객체

**📂 exception** : 입력값 예외처리
- Exception 클래스
    - isCanConvertInt 메소드: String 입력이 int로 변환 가능한지 체크
    - isConConvertIntList 메소드: List<String>이 List<Integer>로 변환 가능한지 체크
    - isCostValid 메소드: private 로또 구입 금액 예외처리 메소드를 모두 실행
    - isAnswerValid 메소드: private 당첨 번호 예외처리 메소드를 모두 실행
    - isBonusValid 메소드: private 보너스 번호 예외처리 메소드를 모두 실행

**📂 service** : DB에 접근하지 않고, 핵심 비즈니스 기능 수행
- Info Enum
  - 생성자: 로또 한장 가격, 로또 한 장당 번호 개수, 로또 가능한 최소 숫자, 로또 가능한 최대 숫자, 순위 개수
- Rank Enum
  - 생성자: 순위별 당첨금, 순위별 출력 내용 String
- MakeLotto 클래스
  - 랜덤 로또를 발행하고 로또를 몇개 구매했는지 계산하는 메소드가 있다.
- Calculate 클래스
  - 로또 당첨번호와 또를 비교하여 등수 인덱스로 반환하는 메소드와 수익률을 계산하는 메소드가 있다.

**📂 view** : 콘솔창 입력/출력 담당
- InputView 클래스: 유저에게 입력을 받을 때 함께 출력
- OutputView 클래스: 랜덤 생성한 모든 로또와 당첨 통계를 출력

**📝 Application** : 클라이언트
- Controller 클래스 실행


테스트코드
---
> 기본으로 주어진 기능 테스트 & 예외테스트에 이어 단위별로 구분해 테스트 코드를 작성해 보았습니다.  

**📂 domain**
-[ ] BonusLottoTest -> 로또 정답 번호와 보너스 번호가 같은 경우 해결 못함
-[x] LottoTest 
-[x] PayTest  

**📂 service**
-[x] CalculateTest

공부한 내용
---
<details>
<summary>MVC</summary>


### 참고자료
___
[MVC 구조](https://murphymoon.tistory.com/entry/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC-MVC-%EB%A6%AC%EB%B7%B0-%EB%A0%88%EC%9D%B4%EC%96%B4-MVC-%ED%8C%A8%ED%84%B4-5%EB%A0%88%EC%9D%B4%EC%96%B4)  
[계층형 vs 도메인형](https://ksh-coding.tistory.com/96)  
[패키지 예시](https://velog.io/@phjppo0918/%E5%88%9D%E5%BF%83-Spring-Boot-%EC%98%88%EC%A0%9C%EB%A5%BC-%ED%86%B5%ED%95%B4-MVC-%ED%8C%A8%ED%84%B4-%EC%84%A4%EA%B3%84)

</details>

<details>
<summary>DTO</summary>

[일급컬렉션](https://jojoldu.tistory.com/412)     
[Getter/Setter 사용 지양에 대한 의문점 해결!](https://velog.io/@backfox/setter-%EC%93%B0%EC%A7%80-%EB%A7%90%EB%9D%BC%EA%B3%A0%EB%A7%8C-%ED%95%98%EA%B3%A0-%EA%B0%80%EB%B2%84%EB%A6%AC%EB%A9%B4-%EC%96%B4%EB%96%A1%ED%95%B4%EC%9A%94)  
[DTO vs VO](https://kbwplace.tistory.com/162)

</details>
