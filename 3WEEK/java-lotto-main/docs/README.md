기능 요약
---
1. `로또 구매`
    - 로또 구입 금액을 입력받음
    - 1000원(1장 가격) * n개
2. `로또 당첨번호 작성`
    - 유저에게 쉼표로 구분되는 중복되지 않는 숫자 6개 입력받음
    - 보너스 번호 입력받음
3. `로또 발행`
    - 로또 구입 개수만큼 발행(n개)
    - 숫자 범위 1~45 에서 랜덤
    - 중복되지 않는 숫자 6개
4. `로또 당첨`
    - 1등: 6개 번호 일치: 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치: 30,000,000원
    - 3등: 4개 번호 일치: 1,500,000원
    - 4등: 4개 번호 일치: 50,000원
    - 5등: 3개 번호 일치: 5,000원
5. `수익률 출력`
    - 소수점 둘째 자리에서 반올림

패키지 분리
---
**📂 controller** : 웹 MVC의 컨트롤러
- 유저 입력 제어 클래스
  - printRequestCost 메소드 호출
  - lottoCost 메소드 호출
  - printRequestAnswerNumber 메소드 호출
  - lottoAnswerNumber 메소드 호출
  - printRequestBonusNumber 메소드 호출
  - lottoBonusNumber 메소드 호출

**📂 service** : DB에 접근하지 않고, 핵심 비즈니스 기능 수행
- 유저 입력 클래스
    - lottoCost 메소드: "구입금액을 입력해 주세요."와 함께 유저에게 로또 금액 받기
    - lottoAnswerNumber 메소드: "당첨 번호를 입력해 주세요."와 함께 유저에게 당첨번호 숫자 6개 받기
    - lottoBonusNumber 메소드: "보너스 번호를 입력해 주세요."와 함께 보너스 번호 1개 받기
- 로또 발행 클래스
    - generatedLotto 메소드: 로또 구입 개수만큼 랜덤 로또 발행하기
- 로또 당첨 클래스
    - findLottoIsAnswer 메소드: 로또 당첨번호와 발행한 로또를 비교하여 당첨 내역 계산하기
    - rateAnswerLotto 메소드: 수익률 계산하기

**📂 repository** : 데이터 객체를 DB에 저장하고 관리(DAO와 유사) - 서비스와 DB를 연결하는 역할
- 저장 클래스
  - 로또 번호 저장 메소드 
  - 구매한 로또 개수 저장 메소드
  - 발행된 로또 번호 저장 메소드

**📂 DB** : 데이터
- 구매한 로또 금액(int) 
- 발행된 로또 번호(List&#60;myLotto&#62;)
- 로또 당첨 번호(List&#60;int&#62;)

**📂 domain** : DB 객체
- 로또 클래스
    - 필드: 구매한 로또 개수, 발행한 로또 번호, 로또 당첨 번호

**📂 exception** : 입력값 예외처리
- 예외처리 클래스
  - 모든 예외처리 체크 메소드: 아래의 예외처리 메소드를 모두 실행
  - 로또 구매 금액 체크 메소드: 1,000원으로 나누어 떨어지지 않는지 체크
  - 당첨 번호 개수 체크 메소드: 당첨 번호가 6개이고 ","로 번호를 구분했는지 체크
  - 보너스 번호 체크 메소드: 당첨 번호가 1개인지 체크
  - 로또 번호 숫자 범위 체크 메소드: 숫자 범위가 1~45인지 체크

**📂view** : 콘솔창에 출력
- 로또 발행 출력 클래스
  - printLotto: 발행한 로또 수량 및 번호 출력
- 로또 당첨 결과 출력 클래스
  - printAnswerLotto: 로또 당첨 결과 출력
- 로또 수익률 출력 클래스
  - printRateWinLotto 메소드: 로또 수익률 출력


공부한 내용
---
<details>
<summary>MVC</summary>

MVC 구조
---
### Model
_____
- 사용되는 모든 값 저장
- controller와 view에 의존하면 안된다.
- 데이터에 대한 순수 로직만 존재

### View
___
- 값 저장 x
- model에만 의존한다.
- model에서 전달된 값만 사용해야 된다.(컨트롤러가 model 데이터 넘겨줌)


### Controller
___
- 값 저장 x
- 값을 변경하려면 model 메소드 호출
- 들어온 요청에 맞게 서비스를 호출하고, 서비스에 의해 로직이 처리된 model 결과를 view에 전달한다.

`요약: 컨트롤러 -> 서비스 호출 -> 모델 처리 -> 결과를 컨트롤러에 반환 -> 반환된 결과 뷰에 전달`

### 참고자료
___
[MVC 구조](https://murphymoon.tistory.com/entry/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC-MVC-%EB%A6%AC%EB%B7%B0-%EB%A0%88%EC%9D%B4%EC%96%B4-MVC-%ED%8C%A8%ED%84%B4-5%EB%A0%88%EC%9D%B4%EC%96%B4)  
[계층형 vs 도메인형](https://ksh-coding.tistory.com/96)  
[패키지 예시](https://velog.io/@phjppo0918/%E5%88%9D%E5%BF%83-Spring-Boot-%EC%98%88%EC%A0%9C%EB%A5%BC-%ED%86%B5%ED%95%B4-MVC-%ED%8C%A8%ED%84%B4-%EC%84%A4%EA%B3%84)

</details>

<details>
<summary>DTO</summary>
DTO를 어떻게 구현할지 고민 끝에 아래의 블로그 내용을 바탕으로 구현해 보았습니다! 

[일급컬렉션](https://jojoldu.tistory.com/412)     
[Getter/Setter 사용 지양에 대한 의문점 해결!](https://velog.io/@backfox/setter-%EC%93%B0%EC%A7%80-%EB%A7%90%EB%9D%BC%EA%B3%A0%EB%A7%8C-%ED%95%98%EA%B3%A0-%EA%B0%80%EB%B2%84%EB%A6%AC%EB%A9%B4-%EC%96%B4%EB%96%A1%ED%95%B4%EC%9A%94)  
[DTO vs VO](https://kbwplace.tistory.com/162)

</details>
