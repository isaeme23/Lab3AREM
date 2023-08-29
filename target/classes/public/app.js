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
            /*
                    createHTMLElement("h2", response.Title, container);
                    createHTMLElement("h3", response.Year, container);
                    createHTMLElement("p", `Director: ${response.Director}`, container);

                    createHTMLElement("p", `Genre: ${response.Genre}`, container);
                    createHTMLElement("p", `Rating: ${response.Rated}`, container);

                    createImage(response.Poster, container);

                    createHTMLElement("p", `Plot: ${response.Plot}`, container);
                    */
                    document.getElementById("getrespmsg").appendChild(container);
                    document.getElementById("getrespmsg").classList.remove("display-none");
        })
};