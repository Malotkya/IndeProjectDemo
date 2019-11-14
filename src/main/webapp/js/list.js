let units, volumeTemplate, weightTemplate;

const listInit = () => {
    let picker = document.querySelector("#listPicker");
    picker.addEventListener("change", getListEvent);

    units = JSON.parse(document.querySelector("#units").value);
    volumeTemplate = document.querySelector(".volume");
    weightTemplate = document.querySelector(".weight");
};

const getListEvent = event => {
    getList(event.currentTarget.value)
};

const getList = date => {
    makeRequest("Week", "date=" + new Date(date).getTime()).then(obj => {
        fillList(obj);
    }).catch(e => {
        console.error(e);
    });
};

const fillList = json => {
    clearList();
    let list = [];

    json.list.forEach(obj => {
        let ingredients = JSON.parse(obj.recipe.ingredients);
        ingredients.forEach(ingredient => {
            let test = find(list, ingredient.item, "name");
            if(test === null) {
                list.push(new Ingredient(ingredient.item, ingredient.unit, ingredient.amount));
            } else {
                test.add(new Ingredient(ingredient.item, ingredient.unit, ingredient.amount));
            }
        });
    });

    let nodeList = document.querySelector("#shoppingList");
    list.forEach(ingredient => nodeList.appendChild(ingredient.buildListItem()));
};

const clearList = () => {
    document.querySelector("#shoppingList").innerHTML = "";
};

const find = (array, object, arrObj) => {
    for(let i=0; i<array.length; i++) {
        let test = array[i];
        if(arrObj === undefined) {
            if(test == object)
                return test;
        } else {
            if(test[arrObj] == object)
                return test;
        }
    }
    return null;
};

class Ingredient {
    constructor(name, code, amount) {
        this.name = name;
        this.code = code;
        this.amount = amount;

        let test = find(units.Volume, this.code, "code");
        if(test !== null) {
            this.units = units.Volume;
        } else {
            test = find(units.Weight, this.code, "code");
            if(test !== null) {
                this.units = units.Weight;
            } else {
                this.units = null;
            }
        }
    }

    add(rhs) {
        if( (rhs.units !== null && this.units !== null) &&
                this.units === rhs.units ) {
            let lhsUnit = find(this.units, this.code, "code").value;
            let rhsUnit = find(this.units, rhs.code, "code").value;

            this.amount = ((this.amount * lhsUnit) + (rhs.amount * rhsUnit)) / lhsUnit;
        } else {
            this.units = null;
            this.amount += rhs.amount;
        }
    }

    get buildListItem() {
        let amount = document.createElement("span");
        amount.setAttribute("class", "amount");
        amount.innerText = this.amount

        let code = document.createElement("span");
        if(this.code === units.Volume) {
            code = volumeTemplate.cloneNode(true);
            code.value = this.code;
        } else if(this.code === units.Weight) {
            code = weightTemplate.cloneNode(true);
            code.value = this.code;
        } else {
            code.innerText = this.code;
        }
        code.addEventListener("change", this.updateAmount);
        code.setAttribute("class", "code");

        let name = document.createElement("span");
        name.setAttribute("class", "name");
        name.innerText = this.name;

        let li = document.createElement("li");

        // TODO: add a remove from list button

        li.appendChild(amount);
        li.appendChild(code);
        li.appendChild(name);

        return li;
    }

    updateAmount = event => {
        let li = event.currentTarget.parentNode;
        let node = li.querySelector(".amount");
        let newCode = li.querySelector(".code").value;

        let currentUnit = find(this.units, this.code, "code").value;
        let newUnit = find(this.units, newCode, "code").value;

        this.amount = (this.amount * currentUnit) / newUnit;
        this.code = newCode;

        node.innerText = this.amount;
    }

}