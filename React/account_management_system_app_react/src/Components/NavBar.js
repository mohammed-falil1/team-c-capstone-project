import { React, useEffect, useState } from "react";
import "../CSS/NavBar.css";
import { useNavigate } from "react-router-dom";

const NavBar = (props) => {
  const navigate = useNavigate();

  return (
    <div className="top-navbar">
      <nav className="  navbar navbar-expand-lg navbar-dark  ">
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/deposit");
                  }}
                >
                  Deposit/Withdraw
                </a>
              </li>
              {/* <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/withdraw");
                  }}
                >
                  Withdraw
                </a>
              </li> */}
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/transfer");
                  }}
                >
                  Transfer
                </a>
              </li>
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/addPayee");
                  }}
                >
                  AddPayee
                </a>
              </li>

              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/BillerRegister");
                  }}
                >
                  Biller Register
                </a>
              </li>
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/BillerPay");
                  }}
                >
                  Biller Pay
                </a>
              </li>
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/BillerStatement");
                  }}
                >
                  Biller Statement
                </a>
              </li>
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/acct-stmt");
                  }}
                >
                  Account Statements
                </a>
              </li>
              <li className="nav-item">
                <a
                  className="nav-link"
                  onClick={() => {
                    navigate("/acct-stmt");
                  }}
                >
                  {props.accountNumber}
                  {console.log(props.accountNumber + " from navbar")}
                </a>
              </li>
            </ul>
           
            <button
              className="btn btn-outline-secondary"
              type="submit"
              href="/"
              id="logout"
            >
              <a href="/" style={{ textDecoration: "none", color: "#fff" }}>
                Logout
              </a>
            </button>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default NavBar;
