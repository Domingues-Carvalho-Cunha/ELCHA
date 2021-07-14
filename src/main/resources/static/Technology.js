window.onload = async function() {
    try {
        let Tasks = await $.ajax({ 
            url: "/api/Tasks/Technology",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let Task of Tasks) {
            html+=`<section onclick='openTasks(${Task.id})'>
                    <h2>${Task.name}</h>
                    <h2>${Task.description}</h>
                    <h2>${Task.gems} gems</h>
                    </section>`
        }
        document.getElementById("Technology").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}