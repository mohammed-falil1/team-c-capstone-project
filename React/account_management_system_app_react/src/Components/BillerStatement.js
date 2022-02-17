import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import NavBar from "../Components/NavBar";

const BillerStatement = (props) => {
  const [from, setFrom] = useState("");
  const [to, setTo] = useState("");
  const [statement, setStatement] = useState([]);

  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };
  useEffect(() => {
    if (from.length > 0 && to.length > 0) {
      const getBillerStatement =
        "http://localhost:8080/biller/biller-stmt/" + from + "/" + to;
      axios.get(getBillerStatement, { headers: headers }).then((body) => {
        setStatement(body.data);
      });
    }
  }, [from, to]);
  return (
    <div>
      <NavBar accountNumber={props.accountNumber} />
      <br></br>
      <center>
        <h1>Biller Statement</h1>
      </center>
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
            <th scope="col">Service</th>
            <th scope="col">Bill No.</th>
            <th scope="col">Amount</th>
          </tr>
        </thead>
        <tbody>
          {statement.map((item, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{item.timeStamp}</td>
              <td>{item.billerService}</td>
              <td>{item.billNumber}</td>
              <td>{item.amount}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default BillerStatement;
