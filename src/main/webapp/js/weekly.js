let day = 86400000;
let dayList = [];

const weeklyInit = () => {
    let picker = document.querySelector("#weekPicker");

    dayList = document.querySelector("#week").querySelectorAll(".day");

    picker.addEventListener("change", getWeekEvent);
    getWeek(picker.value);

    document.querySelector("#weekToList").addEventListener("click", jump);
};

const getWeekEvent = event => {
    getWeek(event.currentTarget.value)
};

const getWeek = date => {
    makeRequest("Week", "date=" + new Date(date).getTime()).then(obj => {
        fillWeek(obj);
    }).catch(e => {
        console.error(e);
    });
};

const fillWeek = json => {
    clearWeek();
    let start = json.start;

    for(let i=0; i<7; i++) {
        let currentDay = new Date(start);
        let node = dayList[i];
        let list = json.list.filter(item => {
            let lhs = new Date(item.date);
            return lhs.getDay() === currentDay.getDay();
        });

        list.forEach(item => {
            node.appendChild(buildRecipe(start, item.recipe));
        });

        start += day;
    }
};

const buildRecipe = (time, recipe) => {
    let p = document.createElement("p");
    p.setAttribute("class", "col-3 border border-secondary m-0");

    let span = document.createElement("a");
    span.setAttribute("href", "Recipe?id=" + recipe.id);
    span.setAttribute("class", "col-12 text-center");
    span.setAttribute("style", "display:inline-block");
    span.innerText = recipe.name;
    p.appendChild(span);

    let button = document.createElement("input");
    button.setAttribute("value", "Remove");
    button.setAttribute("type", "submit");
    button.setAttribute("class", "btn btn-danger");
    button.setAttribute("name", "submit");

    let id = document.createElement("input");
    id.setAttribute("value", recipe.id);
    id.setAttribute("type", "hidden");
    id.setAttribute("name", "id");

    let date = document.createElement("input");
    date.setAttribute("value", time);
    date.setAttribute("type", "hidden");
    date.setAttribute("name", "date");

    let input = document.createElement("form");
    input.setAttribute("class", "confirm col-12 text-center m-1");
    input.setAttribute("action", "Account");
    input.setAttribute("method", "post");
    input.setAttribute("style", "display:inline-block");
    input.onsubmit = confirmDelete;

    input.appendChild(id);
    input.appendChild(date);
    input.appendChild(button);

    p.appendChild(input);

    return p;
};

const clearWeek = () => {
    dayList.forEach(node => {
        node.innerHTML = "";
    })
};

const jump = () => {
    document.querySelector("#listPicker").value = document.querySelector("#weekPicker").value;
    getList(document.querySelector("#listPicker").value);

    document.querySelector("#plannerBtn").setAttribute("class", "nav-link");
    document.querySelector("#listBtn").setAttribute("class", "nav-link active");
    document.querySelector("#planner").setAttribute("class", "tab-pane fade d-hidden");
    document.querySelector("#list").setAttribute("class", "tab-pane fade d-hidden show active");
};