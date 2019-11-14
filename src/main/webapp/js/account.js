const init = () => {
    document.querySelectorAll(".confirm").forEach(function(item){
        item.onsubmit = confirmDelete;
    });
    listInit();
    weeklyInit();
};

window.onload = init;

const confirmDelete = event => {
    let message = event.currentTarget.querySelector(".btn").value;

    if(message === "Unlike")
        message = "Are you sure you want to unlike recipe?";
    else if(message === "Delete")
        message = "Are you sure you want to delete recipe?";
    else if(message === "Remove")
        message = "Are you sure you want to remove recipe from the planner?";
    else
        message = "Are you sure you want to do whatever it is your about to do?";

    return window.confirm(message);
};

const makeRequest = (url, parameters) => {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();

        xhr.open("POST", url);

        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4) {
                if(xhr.status === 200) {
                    resolve(JSON.parse(xhr.responseText));
                } else {
                    reject(new Error(xhr.responseText));
                }
            }
        };

        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(parameters);
    });
};