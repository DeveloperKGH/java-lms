# 수강신청 - 레거시 코드 리팩터링

---

> NEXTSTEP TDD, 클린 코드 with Java 16기, 수강신청(레거시 코드 리팩터링) 관련 미션을 구현한 저장소입니다.

# 목차

- [1단계 - 레거시 코드 리팩터링](#1단계---레거시-코드-리팩터링)
- [2단계 - 수강신청(도메인 모델)](#2단계---수강신청--도메인-모델-)


## 1단계 - 레거시 코드 리팩터링

---

- [x] 질문 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.
- [x] 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
- [x] 답변이 없는 경우 삭제가 가능하다.
- [x] 질문자와 답변글의 모든답변자 같은 경우 삭제가 가능하다.
- [x] 질문을 삭제할 때 답변 또한 삭제해야 하며, 답변의 삭제 또한 삭제 상태(deleted)를 변경한다.
- [x] 질문자와 답변자가 다른경우 답변을 삭제할수없다.
- [x] 질문과 답변 삭제 이력에 대한 정보를 DeleteHistory를 활용해 남긴다.
---

<br>

## 2단계 - 수강신청(도메인 모델)

---

- [x] 과정(Course)은 기수 단위로 여러 개의 강의(Session)를 가질 수 있다.
- [x] 강의는 시작일과 종료일을 가진다.
- [x] 강의는 강의 커버 이미지 정보를 가진다.
- [x] 강의는 무료 강의와 유료 강의로 나뉜다.
- [x] 강의 상태는 준비중, 모집중, 종료 3가지 상태를 가진다.
- [x] 강의 수강신청은 강의 상태가 모집중일 때만 가능하다.
- [x] 강의는 강의 최대 수강 인원을 초과할 수 없다.
---

<br>

## 3단계 - 수강신청(DB 적용)

---

- [ ] 과정(Course) 도메인 모델을 DB 테이블과 매핑하고, 데이터를 저장한다.
- [ ] 강의(Session) 도메인 모델을 DB 테이블과 매핑하고, 데이터를 저장한다.
- [ ] 수강신청(Enrollment) 도메인 모델을 DB 테이블과 매핑하고, 데이터를 저장한다.

---

<br>