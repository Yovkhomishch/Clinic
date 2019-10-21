<#import "parts/common.ftl" as c>

<@c.page>
    List of Workers


    <table>
        <thead>
        <div>
        <tr>Login</tr>
            <tr>   </tr>
        <tr>Role</tr>
        </div>

        </thead>
        <tbody>
        <#list workers as worker>
            <tr>
                <td>${worker.login}</td>
                <td><#list worker.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/worker/${worker.id}">edit</a></td>
            </tr>
        <#else>
            No workers

        </#list>
        </tbody>
    </table>

</@c.page>