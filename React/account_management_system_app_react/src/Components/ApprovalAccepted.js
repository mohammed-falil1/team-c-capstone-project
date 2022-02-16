import axios from "axios";
import React, { useEffect, useState } from "react";
import "../CSS/AdminApproval.css";
import NavBar from "./NavBar";

function ApprovalAccepted(props) {
  const getAcceptedUrl =
    "http://localhost:8080/admin/account-approvals/accepted";

  const [acceptedList, setAcceptedList] = useState([]);

  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  useEffect(() => {
    axios.get(getAcceptedUrl, { headers: headers }).then((response) => {
      setAcceptedList(response.data);
      console.log(response);
    });
  }, []);

  return (
    <div>
      <h1 id="headline">Accepted</h1>
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Serial No.</th>
            <th scope="col">User Id</th>
            <th scope="col">TimeStamp</th>
          </tr>
        </thead>
        <tbody>
          {acceptedList.map((item, index) => (
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

export default ApprovalAccepted;
