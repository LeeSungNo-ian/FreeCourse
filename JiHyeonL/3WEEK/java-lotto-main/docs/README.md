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
5. 수익률 출력
    - 소수점 둘째 자리에서 반올림

패키지 분리
---
**controller**


**model**
- 유저 입력 클래스
  - lottoCost 메소드: 유저에게 로또 금액 받기
  - lottoAnswerNumber 메소드: 유저에게 당첨번호 숫자 6개 받기
  - lottoBonusNumber 메소드: 보너스 번호 1개 받기
- 로또 당첨 클래스
  - findLottoIsAnswer 메소드: 로또 당첨번호와 발행한 로또를 비교하여 당첨 내역 계산하기
  - rateAnswerLotto 메소드: 수익률 계산하기

**view**
- 유저 입력 요청 클래스
  - printRequestCost 메소드: "구입금액을 입력해 주세요." 출력
  - printRequestAnswerNumber 메소드: "당첨 번호를 입력해 주세요." 출력
  - printRequestBonusNumber 메소드: "보너스 번호를 입력해 주세요." 출력
- 로또 발행 출력 클래스
  - printLotto: 발행한 로또 수량 및 번호 출력
- 로또 당첨 내역 출력 클래스
  - printLottoResult 메소드: 당첨 내역 출력
- 로또 수익률 출력 클래스
  - printRateWinLotto 메소드: 로또 수익률 출력

**domain**
- 로또 당첨금

**util**
- 로또 발행 클래스
    - generatedLotto 메소드: 로또 구입 개수만큼 랜덤 로또 발행하기
  
MVC 모델이란?
---
공부하면서 배웠던 내용을 정리해 보았습니다...!

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
[계층형, 도메인형 패키지 예시](https://cheese10yun.github.io/spring-guide-directory/)