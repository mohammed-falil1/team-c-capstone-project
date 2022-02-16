import React, { useState } from "react";
import ApprovalAccepted from "./ApprovalAccepted";
import ApprovalRejected from "./ApprovalRejected";
import ApprovalRequested from "./ApprovalRequested";
import "../CSS/AdminApproval.css";
import { useNavigate } from "react-router-dom";
import NavBar from "./NavBar";

function AdminApproval(props) {
  const requested = "requested";
  const accepted = "approved";
  const rejected = "rejected";

  const navigate = useNavigate();

  const handleLogout = () => {
    navigate("/");
  };

  const [show, setShow] = useState(requested);
  return (
    <div>
     
      <ul class="nav justify-content-center">
        <li class="nav-item">
          <button
            id="btnRequested"
            type="button"
            class="btn btn-warning"
            onClick={() => setShow(requested)}
          >
            Requested
          </button>
        </li>
        <li class="nav-item">
          <button
            id="btnAccepted"
            type="button"
            class="btn btn-success"
            onClick={() => setShow(accepted)}
          >
            Accepted
          </button>
        </li>
        <li class="nav-item">
          <button
            id="btnRejected"
            type="button"
            class="btn btn-danger"
            onClick={() => setShow(rejected)}
          >
            {" "}
            Rejected
          </button>
        </li>
        <li class="nav-item">
          <button
            id="btnLogout"
            type="button"
            class="btn btn-primary"
            onClick={handleLogout}
          >
            {" "}
            Logout
          </button>
        </li>
      </ul>
      <div id="logoutBtn"></div>
      <div>
        {show === requested && <ApprovalRequested token={props.token} />}
      </div>
      <div>{show === accepted && <ApprovalAccepted token={props.token} />}</div>
      <div>{show === rejected && <ApprovalRejected token={props.token} />}</div>
    </div>
  );
}

export default AdminApproval;
