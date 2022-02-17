import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import NavBar from "./NavBar";

function AccountStatements(props) {
  const [from, setFrom] = useState("");
  const [to, setTo] = useState("");
  const [statement, setStatement] = useState([]);
  const [balance, setBalance] = useState();
  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  useEffect(() => {
    const getAccountBalanceUrl =
      "http://localhost:8080/acc/get-balance/" + props.accountNumber;
    axios.get(getAccountBalanceUrl, { headers: headers }).then((response) => {
      setBalance(response.data);
    });
  }, []);

  useEffect(() => {
    if (from.length > 0 && to.length > 0) {
      const getAccountStmts =
        "http://localhost:8080/acc/stmts/" + from + "/" + to;
      axios.get(getAccountStmts, { headers: headers }).then((body) => {
        setStatement(body.data);
      });
    }
  }, [from, to]);
  return (
    <>
      <div>
        <NavBar accountNumber={props.accountNumber} />
        <br></br>
        <center>
          <h1>Account Statements</h1>
        </center>

        <div style={{ position: "relative" }}>
          <h4>Account Number : {props.accountNumber}</h4>
          <h4>Account Balance : {balance}</h4>
        </div>
        <br></br>
        <div style={{ paddingBottom: "20px" }}>
          <label>From</label>
          <input
            className="form-control"
            type="date"
            name="dob"
            id="dob"
            value={from}
            onChange={(e) => setFrom(e.target.value)}
            required
          />
          <label>To</label>
          <input
            className="form-control"
            type="date"
            name="dob"
            id="dob"
            value={to}
            onChange={(e) => setTo(e.target.value)}
            required
          />
        </div>
        <table class="table">
          <thead class="table-dark">
            <tr>
              <th scope="col">Serial No.</th>
              <th scope="col">Date</th>
              <th scope="col">Amount</th>
              <th scope="col">Remarks</th>
            </tr>
          </thead>
          <tbody>
            {statement.map((item, index) => (
              <tr>
                <th scope="row">{index + 1}</th>
                <td>{item.timestamp}</td>
                <td>{item.amount}</td>
                <td>{item.remarks}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default AccountStatements;
