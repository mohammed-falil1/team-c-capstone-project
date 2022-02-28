import React from "react";
import NavBar from "../Components/NavBar";

function AfterLogin(props) {
  return (
    <>
      <NavBar accountNumber={props.accountNumber} />
      
    </>
  );
}

export default AfterLogin;
