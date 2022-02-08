import React from "react";

function ApprovalRejected() {
  return (
    <div>
      <h1>Rejected</h1>
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
        <tbody></tbody>
      </table>
    </div>
  );
}

export default ApprovalRejected;
