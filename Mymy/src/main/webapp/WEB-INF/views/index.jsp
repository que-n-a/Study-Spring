<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/myself.css">
    <title>홈 페이지</title>
</head>

<body>
    <nav class="header">
        <ul>
            <li><a class="home button" href="/home">홈</li>
            <li><a class="aboutme button" href="/aboutMe">자기소개</li>
            <li><a class="myphoto button" href="/photo">내 사진</li>
            <li><a class="wtn button" href="/aboutme/today">지금은 몇 시?</li>
        </ul>
    </nav>

    <nav class="main">
        <h1>풀스텍 개발자가 될거야!</h1>
        <p>함께 개발하고 성장하고 싶어요</p><br>
        <p>그래서 열심히 공부하고 있어요!</p><br>
        <a id="button1" href="/aboutMe">자기소개</a>
        <a id="button2" href="/photo">내 사진</a>
    </nav>

    <p>
        <p id="addressimg" class="adressimg"></p>
    </p>
</body>
<footer>
        <p>이메일 주소<br>
        깃 허브 주소</p>
</footer>

</html>