import React, { useEffect, useState } from "react";
import axios from "axios";
const REST_API_URL = "http://localhost:9000/acc/stmts/2022-01-25/2022-01-25";

function Sample(props) {
  return (
    <div>
      <h1>token = {props.token}</h1>
    </div>
  );
}

export default Sample;
