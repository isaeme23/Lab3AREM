let getFetch = () => {
    let nameVar = document.getElementById("name").value;
    fetch("/movie?name="+nameVar).then(response => response.json())
        .then((response) => {
            document.getElementById("getrespmsg").innerHTML ="";
            let container = document.createElement("div");
            container.innerHTML = "<div class=\"respuesta\">"+
                                                  "<h1> Titulo: " + response.Title + "</h1>"+
                                                  "<div class =\"poster\">"+
                                                  "<img src=\"" + response.Poster +"\">"+
                                                  "</div>"+
                                                  "<h2> A&ntilde;o: " + response.Year+ "</h2>"+
                                                  "<p> Director: " + response.Director + "</p>"+
                                                  "<p> Clasificaci&oacute;n : " + response.Rated + "</p>"+
                                                  "<p> Genero: " + response.Genre + "</p>"+
                                                  "<p> Sinopsis: " + response.Plot + "</p>"+
                                                  "</div>\n";
                    document.getElementById("getrespmsg").appendChild(container);
                    document.getElementById("getrespmsg").classList.remove("display-none");
        })
};
/*
let postFetch = () => {
    let nameVar = document.getElementById("name1").value;
    fetch("/movie"{
        method: POST,
        body: JSON.stringify({name: nameVar})
    }).then((response) => response.json()).then((response) => {
            document.getElementById("postrespmsg").innerHTML ="";
            let container = document.createElement("div");
            container.innerHTML = "<div class=\"respuesta1\">"+
                                                  "<h1> Titulo: " + response.Title + "</h1>"+
                                                  "<div class =\"poster\">"+
                                                  "<img src=\"" + response.Poster +"\">"+
                                                  "</div>"+
                                                  "<h2> A&ntilde;o: " + response.Year+ "</h2>"+
                                                  "<p> Director: " + response.Director + "</p>"+
                                                  "<p> Clasificaci&oacute;n : " + response.Rated + "</p>"+
                                                  "<p> Genero: " + response.Genre + "</p>"+
                                                  "<p> Sinopsis: " + response.Plot + "</p>"+
                                                  "</div>\n";
                    document.getElementById("postrespmsg").appendChild(container);
                    document.getElementById("postrespmsg").classList.remove("display-none");
        })
};
*/