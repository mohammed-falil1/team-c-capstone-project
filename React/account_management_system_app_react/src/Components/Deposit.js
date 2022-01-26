import react from "react";
import React, { useState } from "react";
import ReactDOM from "react-dom";

function Deposit() {
  const [values, setValues] = useState({
    account: "",
    amount: "",
    remarks: "",
  });

  const handleChangeAccount = (event) => {
    setValues((values) => ({
      ...values,
      account: event.target.value,
    }));
  };

  const handleChangeAmount = (event) => {
    setValues((values) => ({
      ...values,
      amount: event.target.value,
    }));
  };

  const handleChangeRemarks = (event) => {
    setValues((values) => ({
      ...values,
      remarks: event.target.value,
    }));
  };

  const handleSubmit = (event) => {
    // alert(values.account+''+values.amount+''+values.remarks)
    alert("Deposit Successful");
    event.preventDefault();
  };

  return (
    <div>
      <div class="form-body ">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Please enter the below details to deposit</h3>
                <form class="requires-validation" onSubmit={handleSubmit}>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter the account number:
                    </label>
                    <input
                      type="text"
                      class="form-control"
                      name="accountNumber"
                      pattern="[0-9]{6}"
                      placeholder="Minimum 6 digits "
                      required
                      value={values.account}
                      onChange={handleChangeAccount}
                    />
                  </div>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Amount to be deposited:
                    </label>
                    <input
                      class="form-control"
                      name="amount"
                      type="number"
                      min="0"
                      placeholder="Enter amount"
                      required
                      value={values.amount}
                      onChange={handleChangeAmount}
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
                      onChange={handleChangeRemarks}
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
