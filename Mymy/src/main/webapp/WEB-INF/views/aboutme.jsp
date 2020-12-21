<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/myself.css">

    <title>자기소개 페이지</title>
</head>
    <nav class="header">
        <ul>
            <li><a href="/home">홈</a></li>
            <li><a href="/aboutMe">자기소개</a></li>
            <li><a href="/photo">내 사진</a></li>
            <li><a href="/aboutme/today">지금은 몇 시?</a></li>
        </ul>
    </nav>

<ul class="li-2">
    <li>
        <h3>이런 것을 잘해요</h3>
    </li>
    <li>
        <p>함께 개발하고 성장하고 싶어요~~~~
            하루하루 발전하는 개발자가 되고 싶습니다.
        </p>
    </li>
</ul>

<ul class="li-2">
    <li>
        <h3>나의 포트폴리오</h3>
    </li>
    <li>
        <p type="button" href="/">링크 주소<br>
            제 홈페이지 입니다.
    </li>
    </p>
    <li>
        <p href="/">깃허브 주소<br>
            제가 주로 개발하는 소스코드 입니다.</p>
    </li>
</ul>

<ul class="li-2">
    <li>
        <h3>나의 최근 프로젝트 설명</h3>
    </li>
    <li>최근 만든 프로젝트는 스프링 프레임워크 기반의 웹 쇼핑몰 만들기 입니다.</li>
</ul>

</body>

<footer>
    <p>이메일 주소<br>
    깃 허브 주소</p>
</footer>

</html>