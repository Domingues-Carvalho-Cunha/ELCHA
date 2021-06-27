window.onload = async function() {
    try {
        let Users = await $.ajax({ 
            url: "/api/Users",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let User of Users) {
            html+=`<section onclick='openUsers(${User.id})'>
                    <h2>${User.firstName}</h>
                    <h2>${User.lastName}</h>
                    <h2>${User.gender}</h>
                    <h2>${User.date}</h>

                    </section>`
        }
        document.getElementById("Users").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}