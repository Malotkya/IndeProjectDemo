const init = () => {
    document.querySelectorAll(".date").forEach(obj => {
        obj.addEventListener("change", submitDate);
    });
}; window.onload = init;

const submitDate = event => {
    let input = event.currentTarget.value;
    if(window.confirm("Add recipe to: " + input)) {
        document.getElementById("hiddenDate").value = new Date(input).getTime();
        event.currentTarget.parentNode.submit();
    }
};