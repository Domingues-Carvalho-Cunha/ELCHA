window.onload = async function() {
    try {
        let Users = await $.ajax({ 
            url: "/api/Users/1",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let User of Users) {
            html+=`<section onclick='openUsers(${User.id})'>
                    <h2>Name: ${User.firstName}</h>
                    <h2>Gender: ${User.gender}</h>
                    <h2>Email: ${User.email}</h>
                    <h2>Birth: ${User.dateOfBirth}</h>
                    <h2>Points: ${User.points}</h>
                    <h2>level: ${User.level}</h>
                    <h2>Gems: ${User.gems} points</h>
                    <h2>Status: ${User.status} points</h>
                    </section>`
        }
        document.getElementById("Perfil").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}