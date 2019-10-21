<#import "parts/common.ftl" as c>

<@c.page>


    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new Report
    </a>

    <div class="collapse" id="collapseExample">


        <form  action="/animal_history/${animal}" method="post">
            <div class="row">

                <div class="col mt-3">

                    <input type="text" name="anamnesis" class="form-control" placeholder="Anamnesis">
                </div>
                <div class="col mt-3">
                    <input type="number" step="any" name="temperature" class="form-control" placeholder="Temperature">
                </div>
                <div class="col mt-3">
                    <input type="text" name="diagnosis" class="form-control" placeholder="Diagnosis">
                </div>
                <div class="col mt-3">
                    <input type="text" name="treatment" class="form-control" placeholder="Treatment">
                </div>

                <div class="col mt-3">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                    <button type="submit" class="btn btn-primary ml-2">Add new Report</button>
                </div>
            </div>
        </form>
    </div>

    <h5>List of Medical Reports</h5>

    <table class="table mt-3">
        <thead>
        <tr>

            <th scope="col">Date</th>
            <th scope="col">Anamnesis</th>
            <th scope="col">Temperature</th>
            <th scope="col">Diagnosis</th>
            <th scope="col">Treatment</th>
            <th scope="col">Worker</th>

        </tr>

        <#list medicalCards as medicalCard>

        <tbody>
        <tr>

            <td> ${medicalCard.date?datetime}</td>
            <td>${medicalCard.anamnesis}</td>
            <td>${medicalCard.temperature}</td>
            <td>${medicalCard.diagnosis}</td>
            <td>${medicalCard.treatment}</td>
            <td>${medicalCard.worker.getLogin()}</td>

        </tr>
        </#list>
        </thead>

        </tbody>
    </table>

</@c.page>