import axios from "axios";
import react, { useEffect } from "react";
import React, { useState } from "react";
import ReactDOM from "react-dom";
import NavBar from "./NavBar";

function Deposit(props) {
  const [values, setValues] = useState({
    amount: "",
    type: "",
    remarks: "",
  });

  const [submit, isSubmitted] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setValues({ ...values, [name]: value });
  };

  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  const handleSubmit = (event) => {
    alert("Deposit Successful");
    values.type = document.getElementById("mySelect").value;
    isSubmitted(true);
    event.preventDefault();
  };

  useEffect(() => {
    if (submit === true) {
      const depositOrWithdrawUrl =
        "http://localhost:8080/acc/depost-or-withdraw";

      axios
        .post(depositOrWithdrawUrl, values, { headers: headers })
        .then((response) => {
          if (response.data === "Insufficient Balance") {
            alert("Sorry ", response.data);
          } else {
            alert("Transaction Successful");
          }
          isSubmitted(false);
        });
    }
  }, [submit]);

  return (
    <div>
      <NavBar accountNumber={props.accountNumber} />
      <div class="form-body ">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Please enter the below details to deposit</h3>
                <form class="requires-validation" onSubmit={handleSubmit}>
                  <div class="col-md-12 mt-3">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Select the Biller Registered Services :
                    </label>
                    <select
                      // value={this.state.selectValue}
                      id="mySelect"
                    >
                      <option value="Credit">Credit</option>
                      <option value="Debit">Debit</option>
                    </select>
                  </div>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter The Amount:
                    </label>
                    <input
                      class="form-control"
                      name="amount"
                      type="number"
                      min="0"
                      placeholder="Enter amount"
                      required
                      value={values.amount}
                      onChange={handleChange}
                    />
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter remarks:
                    </label>
                    <input
                      class="form-control"
                      name="remarks"
                      type="text"
                      placeholder="Enter remarks"
                      required
                      value={values.remarks}
                      onChange={handleChange}
                    />
                  </div>

                  <div class="form-button mt-3">
                    <button id="submit" type="submit" class="btn btn-primary">
                      Deposit
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

export default Deposit;
