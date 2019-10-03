const init = () => {
    let ingredients = JSON.parse(document.getElementById("ingredients").value);
    let directions = JSON.parse(document.getElementById("directions").value);

    let ingredientsList = document.getElementById("ingredientsList");
    let directionsList = document.getElementById("directionsList");

    for(let i=0; i<ingredients.length; i++)
        ingredientsList.innerHTML += "<li class='list-group-item'>" + display(ingredients[i]) + "</li>";

    for(let i=0; i<directions.length; i++)
        directionsList.innerHTML += "<li class='list-group-item'><strong>"+ (i+1) + ":</strong> " + directions[i] + "</li>";
}

const display = value => {
    console.log(value);
    let list = JSON.parse(value);

    console.log(list);

    return list.amount + " " + list.unit + ": " + list.item;
}