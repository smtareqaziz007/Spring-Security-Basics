document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const errorMessage = document.getElementById('errorMessage');
    const inputs = document.querySelectorAll('input');

    loginForm.addEventListener('submit', function(e) {
        // e.preventDefault();

        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

// Simple client-side validation
        if (!email || !password) {
            errorMessage.textContent = 'Please fill in all fields.';
            errorMessage.style.display = 'block';
            return;
        }

// Here you would typically send the data to the server
// For demonstration, we'll just simulate a successful login
        setTimeout(() => {
            alert('Login successful!');
// Redirect or perform other actions here
        }, 1000);
    });

// Add some animation to the form
    inputs.forEach(input => {
        input.addEventListener('focus', function() {
            this.parentNode.classList.add('focus');
        });
        input.addEventListener('blur', function() {
            if (this.value === '') {
                this.parentNode.classList.remove('focus');
            }
        });
    });
});