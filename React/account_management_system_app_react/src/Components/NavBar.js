import { React, useState } from "react";
import "../CSS/NavBar.css";

const handler = () => {};

const NavBar = () => {
  return (
    <div className="top-navbar">
      <nav className="  navbar navbar-expand-lg navbar-dark  ">
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link" href="/">
                  SignUp
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/deposit">
                  Deposit
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/withdraw">
                  Withdraw
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/transfer">
                  Transfer
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/addPayee">
                  AddPayee
                </a>
              </li>

              <li className="nav-item">
                <a className="nav-link" href="/BillerRegister">
                  Biller Register
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/BillerPay">
                  Biller Pay
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/BillerStatement">
                  Biller Statement
                </a>
              </li>
              <li>
                <a className="nav-link" href="/admin-approval">
                  Admin Approval
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
