<#import "parts/common.ftl" as c>

<@c.page>
Worker Editor

    <form action="/worker/${worker.id}" method="post" >

        <input type="text" name="login" value="${worker.login}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${worker.roles?seq_contains(role)?string("checked", "")}> ${role} </label>
            </div>
        </#list>
        <input type="hidden" value="${worker.id}" name="workerId">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Save</button>
    </form>


</@c.page>