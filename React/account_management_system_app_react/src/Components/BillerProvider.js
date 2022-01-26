import React from "react";
// import "../CSS/BillerProvider.css";
import { useState } from "react";

function BillerProvider() {
  const [billerAccount, setBillerAccount] = useState("");
  const [billNo, setBillerNo] = useState("");

  const handleSubmit = (e) => {
    const customer = { billerNo, amount };
    var provider = document.getElementById("select").value;
    var billerNo = document.getElementById("billerno").value;
    var amount = document.getElementById("amount").value;
    console.log("select " + provider);
    console.log("billerNo " + billerNo);
    console.log("billerNo " + amount);
    console.log(
      "url " +
        "http://localhost:8080/billerregister/billername/" +
        provider +
        "/" +
        billerNo +
        "/" +
        amount +
        "/"
    );
    fetch(
      "http://localhost:8080/billerregister/billername/" +
        provider +
        "/" +
        billerNo +
        "/" +
        amount,
      {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      }
    ).then(() => {
      alert("Biller Provider Succesfully. go to Biller transation Page...");
    });
    e.preventDefault();
  };

  return (
    <div>
      <div class="form-body ">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Biller Provider</h3>
                <form class="requires-validation">
                  <div class="col-md-12 mt-3">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Select the Biller Registered Account No :
                    </label>
                    <select
                      // value={this.state.selectValue}
                      id="mySelect"
                    >
                      <option value="">Choose registered account no...</option>
                      <option>56778</option>
                      <option>24567</option>
                      <option>97645</option>
                    </select>
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter Bill No :
                    </label>
                    <input
                      type="number"
                      class="form-control"
                      id="cc-name"
                      placeholder="Enter Your Bill No"
                      required
                    />
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter Amount :
                    </label>
                    <input
                      type="number"
                      class="form-control"
                      id="cc-name"
                      placeholder="Enter Your Bill Amount"
                      required
                    />
                  </div>

                  <div class="form-button mt-3">
                    <button id="submit" type="submit" class="btn btn-primary">
                      Add
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

export default BillerProvider;
