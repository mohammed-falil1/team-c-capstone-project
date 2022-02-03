import React from "react";
import { useState, useEffect } from "react";


  
    const BillerStatement = () => {
        const [biller_statement, setBiller_statement] = useState([]);
      
        const handleClick = (e) => {
          e.preventDefault();
        };
      
        useEffect(() => {
          const customer = { biller_statement };
          fetch("http://localhost:8080/billerstatement/", {
            method: "GET",
            headers: { "Content-Type": "application/json" },
          })
            .then((response) => response.json())
            .then((body) => {
              setBiller_statement(body);
            });
        }, []);
  return (
    <div>
        <br></br>
        <center>
             <h1>Biller Statement</h1> 
             </center>
             <br></br>
    <table class="table">
  <thead class="table-dark">
    <tr>
    <th scope="col">Serial No.</th>
    <th scope="col">Bill No.</th>
    <th scope="col">Transation Id</th>
    <th scope="col">Bill_Register Id</th>
      <th scope="col">Account No.</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>135</td>
      <td>1</td>
      <td>101</td>
      <td>567888</td>
      <td>1000</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>31562</td>
      <td>2</td>
      <td>102</td>
      <td>4156627</td>
      <td>2000</td>
    </tr>
  </tbody>
</table>

  </div>
);
};
export default BillerStatement;
