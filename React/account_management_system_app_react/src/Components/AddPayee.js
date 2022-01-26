import react from "react";
import React, { useState } from "react";
import ReactDOM from "react-dom";
import "../CSS/AddPayee.css";

function AddPayee() {
  const [values, setValues] = useState({ account: "", shortName: "" });

  const handleChangeAccount = (event) => {
    setValues((values) => ({
      ...values,
      account: event.target.value,
    }));
  };

  const handleChangeShortName = (event) => {
    setValues((values) => ({
      ...values,
      shortName: event.target.value,
    }));
  };

  const handleSubmit = (event) => {
    alert("Payee addition Successful");
    event.preventDefault();
  };

  return (
    <div>
      <div class="form-body ">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Please enter the below details to add a payee</h3>
                <form class="requires-validation">
                  <div class="col-md-12 mt-3">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter the payee account number:
                    </label>
                    <input
                      class="form-control"
                      name="accountNumber"
                      type="number"
                      pattern="[0-9]{6}"
                      placeholder="Minimum 6 digits "
                      required
                      defaultValue=""
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
                      value={values.shortName}
                      onChange={handleChangeShortName}
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
