import React, { useEffect, useState } from "react";
import axios from "axios";
const REST_API_URL = "http://localhost:9000/acc/stmts/2022-01-25/2022-01-25";

function Sample() {
  const [data, setData] = useState(1);

  const [no, setNo] = useState(1);

  const handler = () => {
    setData(data + 1);
  };

  const noHandler = () => {
    setNo(no + 1);
  };

  useEffect(() => {
    axios.get(REST_API_URL).then((response) => {
      console.log(JSON.stringify(response.data));
    });
  }, [data]);

  return (
    <div>
      <button onClick={handler}>change</button>
      <button onClick={noHandler}>does not change</button>
      <h1>data = {data}</h1>
      <h1>No = {no}</h1>
    </div>
  );
}

export default Sample;
