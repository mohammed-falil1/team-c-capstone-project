import React from "react";
import NavBar from "../Components/NavBar";
import DepositOrWithdraw from "../Components/DepositOrWithdraw";

function AfterLogin(props) {
  return (
    <>
      <NavBar accountNumber={props.accountNumber} />
      
    </>
  );
}

export default AfterLogin;
