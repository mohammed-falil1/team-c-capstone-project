import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import NavBar from "./NavBar";

function BillerRegister(props) {
  const [billerName, setBillerName] = useState("");
  const [consumerNumber, setConsumerNumber] = useState("");
  const [value, setValue] = useState([]);
  const [submit, isSubmitted] = useState();

  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  useEffect(() => {
    console.log("inside useEffect 1 ");
    const getServicesUrl = "http://localhost:8080/biller/get-services";

    axios.get(getServicesUrl, { headers: headers }).then((body) => {
      console.log(body.data);
      setValue(body.data);
    });
  }, []);

  useEffect(() => {
    console.log("inside useEffect 2 ");
    if (submit) {
      const billerRegisterUrl = "http://localhost:8080/biller/biller-register";
      const billerRegister = {
        billerName: billerName,
        consumerNumber: consumerNumber,
      };
      axios
        .post(billerRegisterUrl, billerRegister, { headers: headers })
        .then(() => {
          alert("registered SuccessFully");
          document.getElementById("consumerno").value = "";
        });
    }
  }, [submit]);

  const handleClick = (e) => {
    setBillerName(document.getElementById("select").value);
    console.log("selected " + billerName);
    console.log("consumerNo " + consumerNumber);
    console.log(document.getElementById("select").value);
    isSubmitted(true);
    e.preventDefault();
  };

  return (
    <div>
         <NavBar accountNumber={props.accountNumber} />
      <div className="form-body ">
        <div className="row">
          <div className="form-holder">
            <div className="form-content">
              <div className="form-items">
                <h3>Biller Register</h3>
                <form className="requires-validation" onSubmit={handleClick}>
                  <div className="col-md-12 mt-3">
                    <label
                      htmlFor="pan-card"
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
                      {value.map((v) => (
                        <option value={v.service}>{v.service}</option>
                      ))}
                    </select>
                  </div>
                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Enter Consumer No :
                    </label>
                    <input
                      type="number"
                      className="form-control"
                      id="consumerno"
                      placeholder="Enter your consumer no"
                      value={consumerNumber}
                      onChange={(e) => setConsumerNumber(e.target.value)}
                      required
                    />
                  </div>

                  <div className="form-button mt-3">
                    <button
                      id="submit"
                      type="submit"
                      className="btn btn-primary"
                    >
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
