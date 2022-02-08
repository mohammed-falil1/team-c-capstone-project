import React, { useState } from "react";
import ApprovalAccepted from "./ApprovalAccepted";
import ApprovalRejected from "./ApprovalRejected";
import ApprovalRequested from "./ApprovalRequested";

function AdminApproval() {
  const requested = "requested";
  const accepted = "approved";
  const rejected = "rejected";

  const [show, setShow] = useState(requested);
  return (
    <div>
      <ul class="nav justify-content-center">
        <li class="nav-item">
          <a
            class="nav-link active"
            aria-current="page"
            href=""
            onClick={() => setShow(requested)}
          >
            Requested
          </a>
        </li>
        <li class="nav-item">
          <button
            type="button"
            class="btn btn-success"
            onClick={() => setShow(accepted)}
          >
            Accepted
          </button>
        </li>
        <li class="nav-item">
          <button
            type="button"
            class="btn btn-danger"
            onClick={() => setShow(rejected)}
          >
            {" "}
            Rejected
          </button>
        </li>
      </ul>

      <div>{show === requested && <ApprovalRequested />}</div>
      <di>{show === accepted && <ApprovalAccepted />}</di>
      <div>{show === rejected && <ApprovalRejected />}</div>
    </div>
  );
}

export default AdminApproval;
