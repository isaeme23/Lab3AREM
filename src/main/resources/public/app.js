let getFetch = () => {
    let nameVar = document.getElementById("name").value;
    fetch("/movie?name="+nameVar).then(response => response.json())
        .then((response) => {
            document.getElementById("getrespmsg").innerHTML ="";
            let container = document.createElement("div");
            container.innerHTML = "<div>"+
                                                  "<h1>" + response.Title + "</h1>"+
                                                  "<h2>" + response.Year+ "</h2>"+
                                                  "<img src=\"" + response.Poster +"\">"+
                                                  "<p>" + response.Director + "</p>"+
                                                  "<p>" + response.Rated + "</p>"+
                                                  "<p>" + response.Genre + "</p>"+
                                                  "<p>" + response.Plot + "</p>"+
                                                  "</div>\n";
                    document.getElementById("getrespmsg").appendChild(container);
                    document.getElementById("getrespmsg").classList.remove("display-none");
        })
};