<div id="wrapper">
    <h1>Hello world!</h1>
    <h2>${CL_ORDERSTATUS}</h2>
    <a href='${pageContext.request.contextPath}?locale=en'>English</a>
    <a href='${pageContext.request.contextPath}?locale=ja'>Japanese</a>
    <spring:message code="i.xx.yy.0001" />
    <p>The time on the server is ${serverTime}.</p>
</div>
<h2>Create Staff Information</h2>
<table>
    <tr>
        <td>Staff First Name</td>
        <td><input type="text" /></td>
    </tr>
    <tr>
        <td>Staff Family Name</td>
        <td><input type="text" /></td>
    </tr>
    <tr>
        <td rowspan="5">Staff Authorities</td>
        <td><input type="checkbox" name="sa" value="01" /> Staff
            Management</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="sa" value="02" /> Master
            Management</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="sa" value="03" /> Stock
            Management</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="sa" value="04" /> Order
            Management</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="sa" value="05" /> Show Shopping
            Management</td>
    </tr>
</table>

<input type="submit" value="cancel" />
<input type="submit" value="confirm" />