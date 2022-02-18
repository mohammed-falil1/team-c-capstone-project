import axios from "axios";
import React, { useEffect, useState } from "react";
import "../CSS/AdminApproval.css";
import NavBar from "./NavBar";

function ApprovalRequested(props) {
  const [requestedList, setRequestedList] = useState([]);
  const [accepted, setAccepted] = useState(false);
  const [rejected, setRejected] = useState(false);

  const [userIdState, setUserIdState] = useState();

  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  const getRequestList =
    "http://localhost:8080/admin/account-approvals/requested";

  const handleSuccess = (userId) => {
    setUserIdState(userId);
    setAccepted(true);
  };

  useEffect(() => {
    console.log(props.token);
    if (accepted === true) {
      const sendAcceptedUrl =
        "http://localhost:8080/admin/account-approval/accepted/" + userIdState;
      console.log(sendAcceptedUrl);
      axios.get(sendAcceptedUrl, { headers: headers });
      setAccepted(false);
    }
  }, [accepted]);

  useEffect(() => {
    if (rejected === true) {
      const sendRejectedUrl =
        "http://localhost:8080/admin/account-approval/rejected/" + userIdState;
      axios.get(sendRejectedUrl, { headers: headers });
      setRejected(false);
    }
  }, [rejected]);

  const handleRejected = (e, userId) => {
    setUserIdState(userId);
    setRejected(true);
    console.log(e.target);
    console.log("userId " + userId);
  };

  useEffect(() => {
    axios.get(getRequestList, { headers: headers }).then((response) => {
      console.log("inside accepted,rejectd use effect");
      console.log("repsonse.data: ", response.data);
      setRequestedList(response.data);
    });
  }, [accepted, rejected]);
  return (
    <div>
      <h1 id="headline">Requested</h1>
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Serial No.</th>
            <th scope="col">User Id</th>
            <th scope="col">Timestamp</th>
            <th scope="col">Accept</th>
            <th scope="col">Reject</th>
          </tr>
        </thead>
        <tbody>
          {requestedList.map((item, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{item.userId}</td>
              <td>{item.timestamp}</td>
              <td>
                <button
                  type="button"
                  class="btn btn-success"
                  onClick={() => handleSuccess(item.userId)}
                >
                  Accept
                </button>
              </td>
              <td>
                <button
                  type="button"
                  class="btn btn-danger"
                  onClick={(e) => handleRejected(e, item.userId)}
                >
                  Reject
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ApprovalRequested;
