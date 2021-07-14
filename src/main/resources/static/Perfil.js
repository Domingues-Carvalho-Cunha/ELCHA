window.onload = async function() {
    try {
        let user = await $.ajax({ 
            url: "/api/Users/1",
            method: "get",
            dataType: "json"
        });
        document.getElementById("id").innerHTML = user.id;
        document.getElementById("firstName").innerHTML = user.firstName;
        document.getElementById("lastName").innerHTML = user.lastName;
        document.getElementById("gender").innerHTML = user.gender;
        document.getElementById("email").innerHTML = user.email;
        document.getElementById("dateOfBirth").innerHTML = user.dateOfBirth;
        document.getElementById("points").innerHTML = user.points;
        document.getElementById("gems").innerHTML = user.gems;
        document.getElementById("status").innerHTML = user.status;
        
    } catch(err) {
        console.log(err);
    }
}