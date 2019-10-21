<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    worker  = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    login = worker.getLogin()
    isAdmin = worker.isAdmin()
    currentWorkerId = worker.getId()
    >

<#else>
    <#assign
    login = "Not logined!"
    isAdmin = false
        currentWorkerId = -1
    >


</#if>