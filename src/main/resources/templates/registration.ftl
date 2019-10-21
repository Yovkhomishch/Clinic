<#import "parts/common.ftl" as c>

<@c.page>
Registartion page

    ${message?if_exists}
    <form action="/registration" method="post">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Login :</label>
            <div class="col-sm-6">
                <input type="text" name="login" class="form-control" placeholder="Login"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" class="btn btn-primary ml-2" value="Add worker"/></div>

    </form>
</@c.page>