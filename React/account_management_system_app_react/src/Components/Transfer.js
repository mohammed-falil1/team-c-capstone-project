import axios from "axios";
import react, { useEffect } from "react";
import React, { useState } from "react";
import ReactDOM from "react-dom";
import NavBar from "./NavBar";

function Transfer(props) {
  const [values, setValues] = useState({
    payeeAccountNumber: "",
    amount: "",
    remarks: "",
  });

  const [submit, isSubmitted] = useState(false);

  const [payeeAccountList, setPayeeAccountList] = useState([]);
  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  const getPayeesUrl = "http://localhost:8080/acc/get-payees";
  const payUrl = "http://localhost:8080/acc/transfer";

  useEffect(() => {
    axios.get(getPayeesUrl, { headers: headers }).then((response) => {
      console.log(response.data);
      setPayeeAccountList(response.data);
    });
  }, []);

  useEffect(() => {
    if (submit === true) {
      axios.post(payUrl, values, { headers: headers }).then((response) => {
        isSubmitted(false);
        document.getElementById("amount").value = "";
        document.getElementById("remarks").value = "";
        if (response.data === true) {
          alert("Money Transferred Sucessfully");
        } else {
          alert("Insufficient Balance");
        }
      });
    }
  }, [submit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({
      ...values,
      [name]: value,
    });
  };

  const handleSubmit = (event) => {
    values.payeeAccountNumber = document.getElementById("mySelect").value;
    isSubmitted(true);
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
                <h3>Please enter the below details to transfer</h3>
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
                      <option value={0}>Choose registered biller</option>
                      {payeeAccountList.map((v) => (
                        <option value={v.payeeAccountNumber}>
                          {v.payeeAccountNumber}-{v.shortName}
                        </option>
                      ))}
                    </select>
                  </div>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Amount to be transferred:
                    </label>
                    <input
                      class="form-control"
                      name="amount"
                      id="amount"
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
                      id="remarks"
                      type="text"
                      placeholder="Enter remarks"
                      required
                      value={values.remarks}
                      onChange={handleChange}
                    />
                  </div>

                  <div class="form-button mt-3">
                    <button id="submit" type="submit" class="btn btn-primary">
                      Transfer
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

export default Transfer;
