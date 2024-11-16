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
│  .DS_Store
│  .gitattributes
│  .gitignore
│  build.gradle
│  gradlew
│  gradlew.bat
│  HELP.md
│  settings.gradle
│
├─.github
│  └─ISSUE_TEMPLATE
│          github-issue-template.md
│
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│
└─src
    ├─main
    │  ├─java
    │  │  └─team8
    │  │      └─nugu
    │  │          │  NuguApplication.java
    │  │          │
    │  │          ├─common
    │  │          │  └─converter
    │  │          │          StringListConverter.java
    │  │          │
    │  │          ├─config
    │  │          │  │  CorsMvcConfig.java
    │  │          │  │  JsonConfig.java
    │  │          │  │  SecurityConfig.java
    │  │          │  │
    │  │          │  ├─filter
    │  │          │  │      JWTFilter.java
    │  │          │  │      LoginFilter.java
    │  │          │  │
    │  │          │  └─jwt
    │  │          │          JWTUtil.java
    │  │          │
    │  │          ├─controller
    │  │          │      IntroController.java
    │  │          │      JoinController.java
    │  │          │      TestController.java
    │  │          │      TestResultController.java
    │  │          │      UserController.java
    │  │          │
    │  │          ├─dto
    │  │          │      CustomUserDetails.java
    │  │          │      IntroDTO.java
    │  │          │      IntroResDTO.java
    │  │          │      LoginDTO.java
    │  │          │      NuguDTO.java
    │  │          │      TestRequestDto.java
    │  │          │      TestResultRequestDto.java
    │  │          │      TestResultResponseDto.java
    │  │          │      TestStatusResponseDto.java
    │  │          │      UserDTO.java
    │  │          │
    │  │          ├─entity
    │  │          │      Intro.java
    │  │          │      TestEntity.java
    │  │          │      TestResultEntity.java
    │  │          │      Users.java
    │  │          │
    │  │          ├─repository
    │  │          │      IntroRepository.java
    │  │          │      TestRepository.java
    │  │          │      TestResultRepository.java
    │  │          │      UserRepository.java
    │  │          │
    │  │          └─service
    │  │                  .gitkeep
    │  │                  CustomUserDetailsService.java
    │  │                  IntroService.java
    │  │                  TestResultService.java
    │  │                  TestService.java
    │  │                  UserService.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │  application.yml
    │      │  bootsecurity.p12
    │      │
    │      ├─static
    │      └─templates
    └─test
        └─java
            └─team8
                └─nugu
                        NuguApplicationTests.java
