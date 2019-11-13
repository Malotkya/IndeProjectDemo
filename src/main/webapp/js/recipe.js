let templateSelect, templateNumber, templateText, templateButton, ingredients, directions, ingredientsList,
    directionsList, directionsInput, dateInput, frmMain;

const init = () => {
    //Used for displaying elements.
    ingredients = JSON.parse(document.getElementById("ingredients").value);
    directions = JSON.parse(document.getElementById("directions").value);
    ingredientsList = document.getElementById("ingredientsList");
    directionsList = document.getElementById("directionsList");
    directionsInput = document.getElementById("directionsInput");
    dateInput = document.getElementById("date");

    //Templates for building edit form.
    templateSelect = document.getElementById("newUnit");
    templateNumber = document.getElementById("newAmount");
    templateText = document.getElementById("newIngredient");
    templateButton = document.getElementById("addNewIngredient");

    show();

    //Add Event Listeners
    addEvent(templateButton, "click", addNewIngredient);
    addEvent(document.getElementById("save"), "click", submit);
    addEvent(document.getElementById("like"), "click", submit);
    addEvent(document.getElementById("delete"), "click", submit);
    addEvent(document.getElementById("edit"), "click", edit);
    addEvent(document.getElementById("cancel"), "click", show);

    frmMain = document.querySelector("form");

    frmMain.onsubmit = validate;
    dateInput.addEventListener("change", checkDate);
}; window.onload = init;

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
    let list = JSON.parse(value);

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
    let node = templateSelect.cloneNode(true);
    node.removeAttribute("id");
    node.setAttribute("class", "unit m-1");

    node.value = value;
    return node;
};

const buildNumber = value => {
    let node = templateNumber.cloneNode(true);
    node.removeAttribute("id");
    node.setAttribute("class", "amount m-1");

    node.value = value;
    return node;
};

const buildText = value => {
    let node = templateText.cloneNode(true);
    node.removeAttribute("id");
    node.setAttribute("class", "value m-1");

    node.value = value;
    return node;
};

const buildButton = value => {
    let node = templateButton.cloneNode(true);
    node.removeAttribute("id");
    node.addEventListener("click", deleteIngredient);
    node.setAttribute("class", "btn btn-danger m-1");

    node.innerText = value;
    return node;
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
    let submit = true;

    if(event.currentTarget.value === "Save") {
        buildJson();
    } else if (event.currentTarget.value === "Delete") {
        if( !window.confirm("Are you sure you want to delete this recipe?") ) {
            submit = false;
        }
    }

    if(submit) {
        event.currentTarget.setAttribute("name", "submitType");
        frmMain.submit();
    }
};

const addEvent = (obj, eType, callback) => {
    if(obj && obj !== 'null' && obj !== 'undefined')
        obj.addEventListener(eType, callback);
};

const checkDate = event => {
    let input = event.currentTarget.value;

    if(window.confirm("Add recipe to: " + input)) {
        document.getElementById("hiddenDate").value = new Date(input).getTime();
        document.getElementById("submitDate").setAttribute("name", "submitType");
        frmMain.submit();
    }
    else {
        document.getElementById("planner").setAttribute("class", "btn btn-primary collapsed");
        document.getElementById("planner").setAttribute("aria-expanded", "false");
        document.getElementById("dateCollapse").setAttribute("class", "collapse");

        event.currentTarget.value = "";
    }
};

//TODO get form to stop submitting on hitting enter
const validate = () => {
    let allNodes = document.querySelector("form").querySelectorAll("input");

    for(let n = 0; n<allNodes.length; n++){

        let list = allNodes[n].attributes;
        for(let i=0; i<list.length; i++) {
            if(list[i].name === "name" && list[i].value === "submitType")
                return true;
        }
    }

    return false;
};