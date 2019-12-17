const init = () => {
    document.querySelector("#newUser").addEventListener("submit", validate);

    document.querySelector("#username").addEventListener("change", checkUserName);
    document.querySelector("#password1").addEventListener("change", checkPassword);
    document.querySelector("#password2").addEventListener("change", comparePassword);
    document.querySelector("#firstName").addEventListener("change", checkFirstName);
    document.querySelector("#lastName").addEventListener("change", checkLastName);
    document.querySelector("#email").addEventListener("change", checkEmail);

    document.querySelector("#join").addEventListener("click", submitForm);

}; window.onload = init;

const submitForm = () => {
    document.querySelector("#newUser").submit();
};

const validate = event => {
    let invalidTest = event.currentTarget.querySelectorAll(".is-invalid").length;

    return invalidTest === 0;
};

const checkUserName = async(event) => {
    let input = event.currentTarget.parentNode;
    let username = input.querySelector("#username").value;


    let response = await fetch(`../GroupProject/thinkingOfSkywalker/uniqueValues/users/user_name/${username}`);

    if(response.ok) {
        let text = await response.text();

        if (text === "true") {
            input.querySelector("input").setAttribute("class", "form-control is-invalid");
            input.querySelector("div").innerText = "Username is already taken";
        } else {
            input.querySelector("input").setAttribute("class", "form-control is-valid");
            input.querySelector("div").innerText = "";
        }
    }
};

const checkPassword = event => {
    let input = event.currentTarget.parentNode;
    let password = input.querySelector("#password1").value;

    if(password === "") {
        input.querySelector("input").setAttribute("class", "form-control is-invalid");
        input.querySelector("div").innerText = "Password can't be empty";
    } else {
        input.querySelector("input").setAttribute("class", "form-control is-valid");
        input.querySelector("div").innerText = "";
    }
};

const comparePassword = event => {
    let input = event.currentTarget.parentNode;
    let password1 = document.querySelector("#password1").value;
    let password2 = document.querySelector("#password2").value;

    if(password1 !== password2) {
        input.querySelector("input").setAttribute("class", "form-control is-invalid");
        input.querySelector("div").innerText = "Passwords must match";
    } else {
        input.querySelector("input").setAttribute("class", "form-control is-valid");
        input.querySelector("div").innerText = "";
    }
};

const checkFirstName = event => {
    let input = event.currentTarget.parentNode;
    let password = input.querySelector("#firstName").value;

    if(password === "") {
        input.querySelector("input").setAttribute("class", "form-control is-invalid");
        input.querySelector("div").innerText = "First Name can't be empty";
    } else {
        input.querySelector("input").setAttribute("class", "form-control is-valid");
        input.querySelector("div").innerText = "";
    }
};

const checkLastName = event => {
    let input = event.currentTarget.parentNode;
    let password = input.querySelector("#lastName").value;

    if(password === "") {
        input.querySelector("input").setAttribute("class", "form-control is-invalid");
        input.querySelector("div").innerText = "Last Name can't be empty";
    } else {
        input.querySelector("input").setAttribute("class", "form-control is-valid");
        input.querySelector("div").innerText = "";
    }
};

const checkEmail = async(event) => {
    let input = event.currentTarget.parentNode;
    let email = input.querySelector("#email").value;


    let response = await fetch(`../GroupProject/thinkingOfSkywalker/validateEmails/${email}`);

    if(response.ok) {
        let text = await response.text();

        if (text === "false") {
            input.querySelector("input").setAttribute("class", "form-control is-invalid");
            input.querySelector("div").innerText = "Please enter a valid email";
        } else {
            input.querySelector("input").setAttribute("class", "form-control is-valid");
            input.querySelector("div").innerText = "";
        }
    }
};