import axios from "axios";
import react from "react";
import React, { useState } from "react";
import ReactDOM from "react-dom";
import "../CSS/AddPayee.css";
import NavBar from "./NavBar";

function AddPayee(props) {
  const initState = { account: "", shortName: "" };
  const [values, setValues] = useState(initState);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setValues({ ...values, [name]: value });
  };

  const handleSubmit = (event) => {
    const headers = {
      "Content-Type": "application/json",
      Authorization: props.token,
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
    };
    const addPayeeUrl = "http://localhost:8080/acc/add-payee";
    const payeeTable = {
      shortName: values.shortName,
      payeeAccountNumber: values.account,
    };
    console.log(values);
    axios
      .post(addPayeeUrl, payeeTable, { headers: headers })
      .then((response) => {
        if (response.data === true) {
          alert("Payee Added Successfully");
        } else {
          alert("Sorry Payee Account Not Found");
        }
      });
    document.getElementById("accountNumber").value = "";
    document.getElementById("shortName").value = "";
    event.preventDefault();
  };

  return (
    <div>
      <NavBar accountNumber={props.accountNumber} />
      <div class="form-body ">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Please enter the below details to add a payee</h3>
                <form class="requires-validation" onSubmit={handleSubmit}>
                  <div class="col-md-12 mt-3">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter the payee account number:
                    </label>
                    <input
                      class="form-control"
                      name="account"
                      type="number"
                      pattern="[0-9]{6}"
                      placeholder="Minimum 6 digits "
                      required
                      id="accountNumber"
                      value={values.account}
                      onChange={handleChange}
                    />
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter short name:
                    </label>
                    <input
                      class="form-control"
                      name="shortName"
                      type="text"
                      placeholder="Enter short name"
                      required
                      id="shortName"
                      value={values.shortName}
                      onChange={handleChange}
                    />
                  </div>

                  <div class="form-button mt-3">
                    <button id="submit" type="submit" class="btn btn-primary">
                      Add Payee
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AddPayee;
