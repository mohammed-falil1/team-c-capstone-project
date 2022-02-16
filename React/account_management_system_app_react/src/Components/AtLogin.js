import React from "react";
import LoginPage from "./LoginPage";

function AtLogin(props) {
  return (
    <div>
      <LoginPage setToken={props.setToken} />
    </div>
  );
}

export default AtLogin;
