let templateSelect, templateNumber, templateText, templateButton = {};
let ingredients, directions, ingredientsList, directionsList, directionsInput = {};
let btnEdit, btnSubmit, btnCancel, btnDelete, btnLike = {};

const init = () => {
    //Used for displaying elements.
    ingredients = JSON.parse(document.getElementById("ingredients").value);
    directions = JSON.parse(document.getElementById("directions").value);
    ingredientsList = document.getElementById("ingredientsList");
    directionsList = document.getElementById("directionsList");
    directionsInput = document.getElementById("directionsInput");

    //Templates for building edit form.
    templateSelect = document.getElementById("newUnit");
    templateNumber = document.getElementById("newAmount");
    templateText = document.getElementById("newIngredient");
    templateButton = document.getElementById("addNewIngredient");

    btnSubmit = document.getElementById("submit");
    btnEdit = document.getElementById("edit");
    btnCancel = document.getElementById("cancel");
    btnDelete = document.getElementById("delete");
    btnLike = document.getElementById("like");

    show();

    //Add Event Listeners
    templateButton.addEventListener("click", addNewIngredient);
    btnSubmit.addEventListener("click", submit);
    btnEdit.addEventListener("click", edit);
    btnCancel.addEventListener("click", show);
    document.querySelector("form").addEventListener("keypress", stopEnter)
};

const show = () => {
    ingredientsList.innerHTML = "";
    directionsList.innerHTML = "";

    for(let i=0; i<ingredients.length; i++)
        ingredientsList.innerHTML += "<li class='list-group-item'>" + displayText(ingredients[i]) + "</li>";

    for(let i=0; i<directions.length; i++)
        directionsList.innerHTML += "<li class='list-group-item'><strong>"+ (i+1) + ":</strong> " + directions[i] + "</li>";

    document.querySelectorAll(".edit").forEach(function(item){
        item.setAttribute("style", "display:none;");
    });

    document.querySelectorAll(".initial").forEach(function(item){
        item.setAttribute("style", "display:inline;");
    });


};

const displayText = value => {
    console.log(value);
    let list = JSON.parse(value);

    console.log(list);

    return list.amount + " " + list.unit + ": " + list.item;
};

const edit = () => {
    ingredientsList.innerHTML = "";
    directionsInput.innerText = "";

    for(let i=0;i<ingredients.length;i++)
        ingredientsList.appendChild(display_html(ingredients[i]));

    for(let i=0; i<directions.length; i++)
        directionsInput.innerHTML += directions[i] + "\n";

    document.querySelectorAll(".edit").forEach(function(item){
        item.setAttribute("style", "display:inline;");
    });

    document.querySelectorAll(".initial").forEach(function(item){
        item.setAttribute("style", "display:none;");
    });
};

const display_html = value => {
    let list = JSON.parse(value);
    return buildAll(list.amount, list.unit, list.item);
};

const buildAll = (amount, unit, item) => {
    let li = document.createElement("li");
    li.setAttribute("class", "list-group-item");

    let objAmount = buildNumber(amount);
    let objUnit   = buildSelect(unit);
    let objItem   = buildText(item);
    let btnDelete = buildButton("Remove");

    li.appendChild(objAmount);
    li.appendChild(objUnit);
    li.appendChild(objItem);
    li.appendChild(btnDelete);

    return li;
};

const buildSelect = value => {
    let unit = templateSelect.cloneNode(true);
    unit.removeAttribute("id");
    unit.setAttribute("class", "unit");

    unit.value = value;

    return unit;
};

const buildNumber = value => {
    let unit = templateNumber.cloneNode(true);
    unit.removeAttribute("id");
    unit.setAttribute("class", "amount");

    unit.value = value;
    return unit;
};

const buildText = value => {
    let unit = templateText.cloneNode(true);
    unit.removeAttribute("id");
    unit.setAttribute("class", "value");


    unit.value = value;
    return unit;
};

const buildButton = value => {
    let unit = templateButton.cloneNode(true);
    unit.removeAttribute("id");
    unit.addEventListener("click", deleteIngredient);

    unit.innerText = value;
    return unit;
};

const addNewIngredient = () => {
    let amount = templateNumber.value;
    let unit = templateSelect.value;
    let item = templateText.value;

    ingredientsList.appendChild(buildAll(amount, unit, item));

    templateNumber.value = "";
    templateSelect.value = "";
    templateText.value = "";
};

const deleteIngredient = event => {
    let li = event.currentTarget.parentNode;
    let ul = li.parentNode;
    let item = li.querySelector(".value");

    if( window.confirm("Are you sure you want to remove: " + item.value) )
        ul.removeChild(li);
};

const buildJson = () => {
    buildIngredientsJson();
    buildDirectionsJson();
};

const buildIngredientsJson = () => {
    let list = ingredientsList.querySelectorAll("li");
    let output = [];

    for(let i=0;i<list.length;i++){
        let obj = {};

        obj.amount = list[i].childNodes[0].value;
        obj.unit   = list[i].childNodes[1].value;
        obj.item   = list[i].childNodes[2].value;

        output.push(JSON.stringify(obj));
    }

    document.getElementById("ingredients").value = JSON.stringify(output);
};

const buildDirectionsJson = () => {
    let list = directionsInput.value.trim().split("\n");
    document.getElementById("directions").value = JSON.stringify(list);
};

const submit = event => {
    event.currentTarget.setAttribute("name", "submit");

    if(event.currentTarget.value == "Save");
        buildJson();
}

const stopEnter = e => {
    e = e || event;
    return (e.keyCode || e.which || e.charCode || 0) !== 13;
};