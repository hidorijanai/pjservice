<div id="wrapper">
    <h1>Hello world!</h1>
    <h2>${CL_ORDERSTATUS}</h2>
    <a href='${pageContext.request.contextPath}?locale=en'>English</a>
    <a href='${pageContext.request.contextPath}?locale=ja'>Japanese</a>
    <spring:message code="i.xx.yy.0001" />
    <p>The time on the server is ${serverTime}.</p>
</div>
