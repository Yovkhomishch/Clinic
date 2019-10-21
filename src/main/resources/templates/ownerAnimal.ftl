<#import "parts/common.ftl" as c>

<@c.page>


    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new Animal
    </a>

    <div class="collapse" id="collapseExample">

        <form  action="/owner_animal/${owner}" method="post">
            <div class="row">

                <div class="col mt-3">
                    <input type="text" name="name" class="form-control" placeholder="Animal name">
                </div>
                <div class="col mt-3">
                    <input type="number" name="age" class="form-control" placeholder="age">
                </div>
                <div class="col mt-3">
                    <input type="text" name="spicies" class="form-control" placeholder="spicies">
                </div>
                <div class="col mt-3">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary ml-2">Add new animal</button>
                </div>
            </div>
        </form>
    </div>

    <h5>List animals</h5>

    <table class="table mt-3">
        <thead>
        <tr>

            <th scope="col">Animal name</th>
            <th scope="col">Animal age</th>
            <th scope="col">Animal spicies</th>

        </tr>

        <#list animals as animal>

        <tbody>
        <tr>

            <td>${animal.name}</td>
            <td>${animal.age}</td>
            <td>${animal.spicies}</td>
            <td>
                <form action="/owner_animal/delete/${animal.getId()}">

                    <button type="submit" class="btn btn-primary ml-2">Delete animal</button>
                </form>
                <form action="/animal_history/${animal.getId()}">
                    <button type="submit" class="btn btn-primary ml-2">Animal medical reports</button>
                </form>





        </tr>
        </#list>
        </thead>

        </tbody>
    </table>

</@c.page>