
        function validate(){
            var fname = document.getElementById("fname").value;
            var name = document.getElementById("uname").value;
            var email = document.getElementById("email").value;
            var date = document.getElementById("date").value;
            var phone = document.getElementById("phone").value;
            var address = document.getElementById("address").value;
            var pan = document.getElementById("pan").value;
            var aadhaar = document.getElementById("aadhaar").value;
            var passFormat=  /^[A-Za-z]\w{7,14}$/;
            var phoneFormat = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
            const emailFormat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
            var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
            var password = document.getElementById("pwd").value;
            var adFormat = /^\d{12}$/;
            var panFormat = /[A-Z]{5}[0-9]{4}[A-Z]{1}/;
            const allowedImageTypes = ['image/jpeg', 'image/png', 'image/jpg'];
            const maxFileSize = 1024 * 1024; // 1MB

            if(/\d/.test(fname))
            {
                alert("The name contains symbols apart from alphabets!");
            }
            if(name == ""){ // checks the emptiness of username
                alert("Username is empty. Please enter a name");
            }
            if(password == ""){ // checks the emptiness of password
                alert("Password is empty. Please enter a password");
            }
            else if(!emailFormat.test(email)) // checks the email format 
            {
                alert("Not a valid email!");
            }
            else if(!dateformat.test(date)){
                alert("Not a valid dob.PLease enter a valid date of birth")
            }
            else if(!phoneFormat.test(phone)){
                alert("Not a valid phone number.Please enter a valid phone number")
            }
             else if(!passFormat.test(password)){
                alert("Not a valid password.Please enter a new password")
            }
             else if(!adFormat.test(aadhaar)){
                alert("Not a valid Aadhaar number.Please enter a new Aadhar number")
            } 
             else if(!panFormat.test(pan)){
                alert("Not a valid Pan number.Please enter a new Pan number")
            }  
            else if (adhaarImage) {
                if (adhaarImage.size > maxFileSize) {
                    alert("Aadhaar image is too large. Maximum size is 1MB.");
                    return false;
                }
                if (!allowedImageTypes.includes(adhaarImage.type)) {
                    alert("Invalid Aadhaar image type. Please upload a JPG, JPEG or PNG file.");
                    return false;
            }
            }
            else if (panImage) {
                if (panImage.size > maxFileSize) {
                    alert("PAN image is too large. Maximum size is 1MB.");
                    return false;
                }
                if (!allowedImageTypes.includes(panImage.type)) {
                    alert("Invalid PAN image type. Please upload a JPG, JPEG or PNG file.");
                    return false;
                }
            }
            else if (id-file) {
                if (id-file.size > maxFileSize) {
                    alert("PAN image is too large. Maximum size is 1MB.");
                    return false;
                }
                if (!allowedImageTypes.includes(id-file.type)) {
                    alert("Invalid PAN image type. Please upload a JPG, JPEG or PNG file.");
                    return false;
                }
            }

        }
    