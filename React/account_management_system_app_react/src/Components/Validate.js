function Validate(values, aadharFile, panCardFile, isChecked) {
  const calculateAge = (dob) => {
    var today = new Date();
    var birthDate = new Date(dob);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    console.log("typeof age ", typeof age);

    return age;
  };

  let errors = {};
  console.log("mobile number length ", values.mobileNumber.length);
  var age = calculateAge(values.dob);
  if (values.fullName.length < 1) {
    errors.fullName = "Full Name is required";
  }
  if (age < 17) {
    errors.dob = "Minimum age is 18";
  } else if (isNaN(age)) {
    errors.dob = "Date of birth is required";
  }

  if (!values.email) {
    errors.email = "Email required";
  } else if (!/\S+@\S+\.\S+/.test(values.email)) {
    errors.email = "Email address is invalid";
  }

  if (values.mobileNumber.toString().length < 1) {
    errors.mobileNumber = "Mobile number required";
  } else if (values.mobileNumber.toString().length > 11) {
    errors.mobileNumber = "Mobile number is invalid";
  }

  if (values.panCard.toString().length < 1) {
    errors.panCard = "PanCard  required";
  } else if (values.panCard.toString().length > 10) {
    errors.panCard = "PanCard  is invalid";
  }

  if (values.aadhar.length < 1) {
    errors.aadhar = "Aadhar number required";
  } else if (values.aadhar.length > 12) {
    errors.mobileNumber = "Aadhar number is invalid";
  }

  if (values.initialBalance < 1000) {
    errors.initialBalance = "Sorry initial balance should be 1000";
  }

  if (aadharFile === null) {
    errors.aadharFile = "Aadhar pdf is required";
  }

  if (panCardFile === null) {
    errors.panCardFile = "Pancard pdf is required";
  }

  if (isChecked === false) {
    errors.isChecked = "Please click the check box";
  }

  return errors;
}

export default Validate;
