import { React, useEffect, useState } from "react";
import axios from "axios";

function useForm({ submitForm, Validate }) {
  const [values, setValues] = useState({
    title: "Mr",
    fullName: "",
    dob: "",
    email: "",
    mobileNumber: "",
    panCard: "",
    aadhar: "",
    initialBalance: "",
  });
  const baseURL = "http://localhost:8080/visit/new-account";

  const [aadharFile, setAadharFile] = useState(null);
  const [panCardFile, setPanCardFile] = useState(null);
  const [isChecked, setIsChecked] = useState(false);

  const [errors, setErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({
      ...values,
      [name]: value,
    });
    console.log("json  " + JSON.stringify(value));
  };

  const handleCheckBox = (e) => {
    if (e.target.checked) {
      setIsChecked(true);
    } else {
      setIsChecked(false);
    }
  };

  const handleFileSelected = (e) => {
    if (e.target.name === "aadhar-file") {
      setAadharFile(e.target.files[0]);
    } else {
      setPanCardFile(e.target.files[0]);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("after clicking register ", JSON.stringify(values));
    setErrors(Validate(values, aadharFile, panCardFile, isChecked));
    setIsSubmitting(true);
  };
  useEffect(() => {
    console.log("inside useEffect");
    if (Object.keys(errors).length === 0 && isSubmitting) {
      console.log(JSON.stringify(Object.keys(errors)));
      // let formData = new FormData();
      let sendBackEnd = {
        title: values.title,
        fullName: values.fullName,
        dob: values.dob,
        email: values.email,
        mobileNumber: values.mobileNumber,
        panCard: values.panCard,
        aadhar: values.aadhar,
        uploadAddress: "somethingAddress",
        initialBalance: values.initialBalance,
        panCardFile: panCardFile,
        aadharFile: aadharFile,
      };

      // formData.append("user",sendBackEnd);
      // // formData.append("aadhar",aadharFile);
      // // formData.append("pancard",panCardFile);
      const headers = {
        // 'Authorization': 'Bearer my-token',
        "Content-Type": "application/x-www-form-urlencoded",
      };

      axios
        .post(baseURL, sendBackEnd, panCardFile, aadharFile, headers)
        .then(() => {
          alert("User Successfully registered ");
        });
      submitForm();
    }
  }, [errors]);
  return {
    handleChange,
    handleSubmit,
    values,
    errors,
    handleFileSelected,
    handleCheckBox,
  };
}

export default useForm;
