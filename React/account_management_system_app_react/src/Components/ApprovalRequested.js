import axios from "axios";
import React, { useEffect, useState } from "react";

function ApprovalRequested() {
  const [requestedList, setRequestedList] = useState([]);
  const [accepted, setAccepted] = useState(false);
  const [rejected, setRejected] = useState(false);

  const getRequestList =
    "http://localhost:8080/admin/account-approvals/requested";

  const handleSuccess = (e, userId) => {
    console.log(e.target);
    console.log("userId " + userId);
    setAccepted(userId);
  };

  useEffect(() => {
    if (accepted ===true) {
      const sendAcceptedUrl =
        "http://localhost:8080/admin/account-approval/accepted/";
    }
  }, [accepted]);

  useEffect(() => {
    if (rejected === true) {
    }
  }, [rejected]);

  const handleRejected = (e, userId) => {
    console.log(e.target);
    console.log("userId " + userId);
  };

  useEffect(() => {
    axios.get(getRequestList).then((response) => {
      setRequestedList(response.data);
    });
  }, [accepted, rejected]);
  return (
    <div>
      <h1>Requested</h1>
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th scope="col">Serial No.</th>
            <th scope="col">Date</th>
            <th scope="col">User Id</th>
            <th scope="col">Accept</th>
            <th scope="col">Reject</th>
          </tr>
        </thead>
        <tbody>
          {requestedList.map((item, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{item.timestamp}</td>
              <td>{item.userId}</td>
              <td>
                <button
                  type="button"
                  class="btn btn-success"
                  onClick={(e) => handleSuccess(e, item.userId)}
                >
                  Success
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
