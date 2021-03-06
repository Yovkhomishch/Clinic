<#macro login path >
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Login :</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Login"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div> <button class="btn btn-primary" type="submit">Sign In</button></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>