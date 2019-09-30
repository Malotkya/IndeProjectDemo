const init = () => {
    let btnSubmit = document.getElementById("submit");
    btnSubmit.addEventListener("click", buildJSON);

    populateLists();
}

const populateLists = () => {
    let ingredients = JSON.parse(document.getElementById("ingredients").value);
    let directions = JSON.parse(document.getElementById("directions").value);

    let ingredientsList = document.getElementById("ingredientsList");
    let directionsList = document.getElementById("directionsList");

    for(let i=0; i<ingredients.size(); i++)
        ingredientsList.innerHTML += "<li>" + ingredients[i] + "</li>";

    for(let i=0; i<directions.size(); i++)
        directionsList.innerHTML += "<li>" + directions[i] + "</li>";
}

const buildJSON = () => {
    let ingredients = document.getElementById("ingredientsList").getElementsByTagName("li");
    let directions = document.getElementById("directionsList").getElementsByTagName("li");

    document.getElementById("ingredients").value = JSON.stringify(ingredients);
    document.getElementById("directions").value = JSON.stringify(ingredients);
}