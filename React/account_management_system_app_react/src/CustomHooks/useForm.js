import { React, useEffect, useState } from "react";
import axios from "axios";
import FormData from "form-data";

function useForm({ submitForm, Validate }) {
  const [values, setValues] = useState({
    title: "Mr",
    fullName: "Mohammed",
    dob: "2000-07-13",
    email: "mohammed_falil@outlook.com",
    mobileNumber: "8680980924",
    panCard: "111111",
    aadhar: "111111",
    initialBalance: "1000",
  });
  const newAccountUrl = "http://localhost:8080/visit/new-account";
  const aadharUploadUr = "http://localhost:8080/visit/upload-aadhar";
  const panCardUploadUrl = "http://localhost:8080/visit/upload-pancard";

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

      let user = {
        title: values.title,
        fullName: values.fullName,
        dob: values.dob,
        email: values.email,
        mobileNumber: values.mobileNumber,
        panCardNumber: values.panCard,
        aadharNumber: values.aadhar,
        uploadAddress: "somethingAddress",
        initialBalance: values.initialBalance,
      };

      axios.post(newAccountUrl, user);

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
