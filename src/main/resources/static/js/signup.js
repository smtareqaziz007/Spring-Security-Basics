// JavaScript for form validation and dynamic effects
document.getElementById('signupForm').addEventListener('submit', function (event) {
    var isValid = true;

    // Clear all error messages
    var errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach(function (error) {
        error.style.display = 'none';
    });

    // Validate Name
    var nameInput = document.getElementById('name');
    if (nameInput.value.trim() === '') {
        document.getElementById('nameError').style.display = 'block';
        isValid = false;
    }

    // Validate Email
    var emailInput = document.getElementById('email');
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(emailInput.value.trim())) {
        document.getElementById('emailError').style.display = 'block';
        isValid = false;
    }

    // Validate Password
    var passwordInput = document.getElementById('password');
    if (passwordInput.value.trim().length < 6) {
        document.getElementById('passwordError').style.display = 'block';
        isValid = false;
    }

    // If form is not valid, prevent submission
    if (!isValid) {
        event.preventDefault();
    }
});

// Add a click event to the Google button
document.querySelector('.google-btn').addEventListener('click', function () {
    alert('Google Sign Up is currently unavailable.');
});
