window.onload = async function() {
    try {
        let Users = await $.ajax({ 
            url: "/api/Users/leaderboard",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let User of Users) {
            html+=`<section onclick='openUsers(${User.id})'>
                    <h2>${User.firstName}</h>
                    <h2>${User.points} points</h>
                    </section>`
        }
        document.getElementById("Users").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}