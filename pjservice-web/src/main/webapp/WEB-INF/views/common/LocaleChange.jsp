<a href='${pageContext.request.contextPath}?locale=en'>English</a>
<a href='${pageContext.request.contextPath}?locale=ja'>Japanese</a>
<spring:message code="i.xx.yy.0001" />

<!-- omitted -->

<meta name="contextPath" content="${pageContext.request.contextPath}" />

<sec:csrfMetaTags />

<!-- omitted -->

<!-- (7)  -->
<form id="calculationForm">
    <input name="number1" type="text">+
    <input name="number2" type="text">
    <button onclick="return plus()">=</button>
    <span id="calculationResult"></span> <!-- (8) -->
</form>