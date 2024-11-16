# 여긴 어디? 나는 누구!
다 함께 만들어가는 트렌디한 자기소개, 누구


![image](https://github.com/user-attachments/assets/3fe1fe30-cb7a-45de-918f-1721f43870d1)

## 시작 가이드

### Requirements
For building and running the application you need:
- Java 17 이상
- Spring Boot 3.x
- MySQL 8.0 이상
- Gradle 7.x 이상

### Installation
```bash
$ git clone https://github.com/Line4Thon-Nugu/Nugu-Backend.git
```
### Service Address
```
https://nugu-line4.vercel.app/
```

## Stacks

### Environment
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

### Framework
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

### Security
<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"><img src="https://img.shields.io/badge/jsonwebtokens-6DB33F?style=for-the-badge&logo=jsonwebtokens&logoColor=white">

### Database
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 

### Deployment
<img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> 

## 화면 구성 

| 누구 페이지    | 누구 소개 | 누구 테스트 |
| -------- | ------- | ------ |
| <img width="818" alt="Screenshot 2024-11-16 at 1 26 07 PM" src="https://github.com/user-attachments/assets/e74b7b55-e7bf-4105-a1ec-a5eeb98603d6"> |  <img width="900" alt="Screenshot 2024-11-16 at 1 27 22 PM" src="https://github.com/user-attachments/assets/71969c70-2a72-4fe0-a004-cd0bd1a57b0a"> | <img width="926" alt="Screenshot 2024-11-16 at 1 28 32 PM" src="https://github.com/user-attachments/assets/b8978554-104f-47aa-9056-d5d081d8f820"> |

## 주요 기능

## Architecture

### Directory Tree
<br/>│  .DS_Store
<br/>│  .gitattributes
<br/>│  .gitignore
<br/>│  build.gradle
<br/>│  gradlew
<br/>│  gradlew.bat
<br/>│  HELP.md
<br/>│  settings.gradle
<br/>│
<br/>├─.github
<br/>│  └─ISSUE_TEMPLATE
<br/>│          github-issue-template.md
<br/>│
<br/>├─gradle
<br/>│  └─wrapper
<br/>│          gradle-wrapper.jar
<br/>│          gradle-wrapper.properties
<br/>│
<br/>└─src
<br/>    ├─main
<br/>    │  ├─java
<br/>    │  │  └─team8
<br/>    │  │      └─nugu
<br/>    │  │          │  NuguApplication.java
<br/>    │  │          │
<br/>    │  │          ├─common
<br/>    │  │          │  └─converter
<br/>    │  │          │          StringListConverter.java
<br/>    │  │          │
<br/>    │  │          ├─config
<br/>    │  │          │  │  CorsMvcConfig.java
<br/>    │  │          │  │  JsonConfig.java
<br/>    │  │          │  │  SecurityConfig.java
<br/>    │  │          │  │
<br/>    │  │          │  ├─filter
<br/>    │  │          │  │      JWTFilter.java
<br/>    │  │          │  │      LoginFilter.java
<br/>    │  │          │  │
<br/>    │  │          │  └─jwt
<br/>    │  │          │          JWTUtil.java
<br/>    │  │          │
<br/>    │  │          ├─controller
<br/>    │  │          │      IntroController.java
<br/>    │  │          │      JoinController.java
<br/>    │  │          │      TestController.java
<br/>    │  │          │      TestResultController.java
<br/>    │  │          │      UserController.java
<br/>    │  │          │
<br/>    │  │          ├─dto
<br/>    │  │          │      CustomUserDetails.java
<br/>    │  │          │      IntroDTO.java
<br/>    │  │          │      IntroResDTO.java
<br/>    │  │          │      LoginDTO.java
<br/>    │  │          │      NuguDTO.java
<br/>    │  │          │      TestRequestDto.java
<br/>    │  │          │      TestResultRequestDto.java
<br/>    │  │          │      TestResultResponseDto.java
<br/>    │  │          │      TestStatusResponseDto.java
<br/>    │  │          │      UserDTO.java
<br/>    │  │          │
<br/>    │  │          ├─entity
<br/>    │  │          │      Intro.java
<br/>    │  │          │      TestEntity.java
<br/>    │  │          │      TestResultEntity.java
<br/>    │  │          │      Users.java
<br/>    │  │          │
<br/>    │  │          ├─repository
<br/>    │  │          │      IntroRepository.java
<br/>    │  │          │      TestRepository.java
<br/>    │  │          │      TestResultRepository.java
<br/>    │  │          │      UserRepository.java
<br/>    │  │          │
<br/>    │  │          └─service
<br/>    │  │                  .gitkeep
<br/>    │  │                  CustomUserDetailsService.java
<br/>    │  │                  

