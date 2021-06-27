window.onload = async function() {
    let unitId = sessionStorage.getItem("unitId");
    await showUnit(unitId);
    await showUnitPlans(unitId);
}

async function showUnit(id) {
    try {
        let unit = await $.ajax({ 
            url: `/api/units/${id}`,
            method: "get",
            dataType: "json"
        });
        document.getElementById("unitName").innerHTML = unit.name;
        document.getElementById("name").innerHTML = unit.name;
        document.getElementById("credits").innerHTML = unit.credits;
    } catch(err) {
        console.log(err);
    }
}

async function showUnitPlans(id) {
    try {
        let unitPlans = await $.ajax({ 
            url: `/api/units/${id}/plans`,
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let unitPlan of unitPlans) {
            html+=`<section>  
                    <h2>Course: ${unitPlan.courseName} </h2>
                    <h3>${unitPlan.semester}º semester </h3>
                    <p>Name: ${unitPlan.name}</p>
                    </section>`
        }
        document.getElementById("plans").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}