const init = () => {
    document.querySelectorAll(".confirm").forEach(function(item){
        item.onsubmit = confirmDelete;
    })
};

window.onload = init;

const confirmDelete = event => {
    let message = event.currentTarget.querySelector(".btn").value;

    if(message === "Unlike")
        message = "Are you sure you want to unlike recipe?";
    else if(message === "Delete")
        message = "Are you sure you want to delete recipe?";
    else
        message = "Are you sure you want to do whatever it is your about to do?";

    return window.confirm(message);
};