import axios from "axios";
import React, { useEffect, useState } from "react";
import "../CSS/AdminApproval.css";
import NavBar from "./NavBar";

function ApprovalRejected(props) {
  const [rejectedList, setRejectedList] = useState([]);
  const getRejectedList =
    "http://localhost:8080/admin/account-approvals/rejected";

  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  useEffect(() => {
    axios.get(getRejectedList, { headers: headers }).then((response) => {
      setRejectedList(response.data);
      console.log(response.data);
    });
  }, []);

  return (
    <div>
      <h1 id="headline">Rejected</h1>
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Serial No.</th>
            <th scope="col">User Id</th>
            <th scope="col">TimeStamp</th>
          </tr>
        </thead>
        <tbody>
          {rejectedList.map((item, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{item.userId}</td>
              <td>{item.timestamp}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ApprovalRejected;
