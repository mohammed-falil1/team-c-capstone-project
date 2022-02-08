import axios from "axios";

import React, { useEffect } from "react";

import { useState } from "react";

function BillerPay() {
  const [billNumber, setBillerNumber] = useState("");
  const [amount, setAmount] = useState("");
  const [submit, isSubmitted] = useState(false);
  const [registeredBiller, setRegisteredBiller] = useState([]);

  const handleSubmit = (e) => {
    console.log("billerNo " + billNumber);
    console.log("amount " + amount);
    isSubmitted(true);
    e.preventDefault();
  };
  useEffect(() => {
    const myBillers = "http://localhost:8080/biller/mybillers/100001";
    axios.get(myBillers).then((body) => {
      console.log(body.data);
      setRegisteredBiller(body.data);
    });
  }, []);
  useEffect(() => {
    if (submit === true) {
      let provider = document.getElementById("mySelect").value;
      console.log("select " + provider);
      const billPayUrl = "http://localhost:8080/biller/biller-pay";
      const billerPay = {
        amount: amount,
        billNumber: billNumber,
        billerService: provider,
      };
      axios.post(billPayUrl, billerPay).then((body) => {
        console.log(body);
        alert("Success");
      });
      console.log("sent");
    }
  }, [submit]);
  
  return (
    <div>
      <div class="form-body ">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Biller Pay</h3>
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
                      {registeredBiller.map((v) => (
                        <option value={v.billerName}>{v.billerName}</option>
                      ))}
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
                      value={billNumber}
                      onChange={(e) => setBillerNumber(e.target.value)}
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
                      value={amount}
                      onChange={(e) => setAmount(e.target.value)}
                      placeholder="Enter Your Bill Amount"
                      required
                    />
                  </div>

                  <div class="form-button mt-3">
                    <button id="submit" type="submit" class="btn btn-primary">
                      Pay
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

export default BillerPay;
