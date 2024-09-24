<!-- signup.js -->
document.addEventListener('DOMContentLoaded', function() {
    const signupForm = document.getElementById('signupForm');
    const errorMessage = document.getElementById('errorMessage');
    const inputs = document.querySelectorAll('input');
    const toggleSwitch = document.querySelector('.theme-switch input[type="checkbox"]');

    signupForm.addEventListener('submit', function(e) {
        // e.preventDefault();

        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

// Simple client-side validation
        if (!name || !email || !password) {
            errorMessage.textContent = 'Please fill in all fields.';
            errorMessage.style.display = 'block';
            return;
        }

// Here you would typically send the data to the server
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

// Dark mode toggle
    function switchTheme(e) {
        if (e.target.checked) {
            document.documentElement.setAttribute('data-theme', 'dark');
            document.body.classList.add('dark-theme');
        } else {
            document.documentElement.setAttribute('data-theme', 'light');
            document.body.classList.remove('dark-theme');
        }
    }

    toggleSwitch.addEventListener('change', switchTheme, false);
});