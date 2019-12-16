const init = () => {
    document.querySelector("form").addEventListener("submit", validateInput);

}; window.onload = init;

const validateInput = event => {
    let form = event.currentTarget;
    let submit = true;

    form.querySelector(".not-null").forEach(input => {
        if(input.value === "") {
            submit = false;
            input.class += "is-invalid";
        }
    });

    return submit;
};