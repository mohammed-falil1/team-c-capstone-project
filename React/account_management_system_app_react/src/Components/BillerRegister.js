import React from "react";
import { useState } from "react";

function BillerRegister() {
  const [billerName, setBillerName] = useState("");
  const [consumerNumber, setConsumerNumber] = useState("");

  const handleClick = (e) => {
    const customer = { billerName, consumerNumber };
    var provider = document.getElementById("select").value;
    var consumerNo = document.getElementById("consumerno").value;
    console.log("select " + provider);
    console.log("consumerNo " + consumerNo);
    console.log(
      "url " +
        "http://localhost:8080/billerprovider/add/" +
        provider +
        "/" +
        consumerNo +
        "/"
    );
    fetch(
      "http://localhost:8080/billerprovider/add/" + provider + "/" + consumerNo,
      {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      }
    ).then(() => {
      alert("Biller Registered Succesfully. go to Biller Provider Page...");
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
                <h3>Biller Register</h3>
                <form class="requires-validation" onSubmit={handleClick}>
                  <div class="col-md-12 mt-3">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Biller Name :
                    </label>
                    <select
                      id="select"
                      value={billerName}
                      onChange={(e) => setBillerName(e.target.value)}
                      required
                    >
                      <option value="">Choose the biller services </option>
                      <option value="jio">Jio</option>
                      <option value="Airtel">Airtel</option>
                      <option value="SpectraNet">SpectraNet</option>
                    </select>
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter Consumer No :
                    </label>
                    <input
                      type="number"
                      class="form-control"
                      id="consumerno"
                      placeholder="Enter your consumer no"
                      value={consumerNumber}
                      onChange={(e) => setConsumerNumber(e.target.value)}
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
export default BillerRegister;
