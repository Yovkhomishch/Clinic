<#import "parts/common.ftl" as c>
<@c.page>
    <div><h5>List of patients</h5> </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by phone">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Owner
    </a>
    <div class="collapse"  id="collapseExample">

        <form action="/main" method="post">
            <div class="row" >
                <div class="col mt-3">
                    <input type="text" name="ownerName" class="form-control" placeholder="First name">
                </div>
                <div class="col mt-3">
                    <input type="text" name="ownerSurname" class="form-control" placeholder="Last name">
                </div>
                <div class="col mt-3">
                    <input type="text" name="ownerPhone" class="form-control" placeholder="Phone number">
                </div>
                <div class="col mt-3">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary ml-2">Add new patient</button>
                </div>
            </div>
        </form>
    </div>
    <div>


    <table class="table mt-3">
        <thead>
        <tr>

            <th scope="col">Owner name</th>
            <th scope="col">Owner surname</th>
            <th scope="col">Owner phone</th>
            <th scope="row" >List animal</th>
        </tr>
        </thead>
         <#list owners as owner>
        <tbody>
        <tr>

            <td>${owner.name}</td>
            <td>${owner.surName}</td>
            <td>${owner.mobilePhone}</td>
            <td><a href="/owner_animal/${owner.getId()}" >Animals</a></td>




        </tr>
        </#list>

        </tbody>
    </table>

</@c.page>