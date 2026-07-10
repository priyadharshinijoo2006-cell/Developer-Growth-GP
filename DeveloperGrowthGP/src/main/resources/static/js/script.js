document.addEventListener("DOMContentLoaded", function () {

    const registerForm = document.querySelector("form");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");
    const passwordError = document.getElementById("passwordError");

    if (registerForm && password && confirmPassword) {

        registerForm.addEventListener("submit", function (event) {

            passwordError.textContent = "";

            if (password.value !== confirmPassword.value) {
                event.preventDefault();
                passwordError.textContent = "Passwords do not match";
            }
        });
    }
});