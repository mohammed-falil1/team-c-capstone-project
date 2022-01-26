import { React, useState } from "react";
import "../CSS/NavBar.css";

const handler = () => {};

const NavBar = () => {
  return (
    <div className="top-navbar">
      <nav className="  navbar navbar-expand-lg navbar-dark  ">
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          {/* <a className="navbar-brand" href="/">
            Home
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button> */}

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
                <a className="nav-link" href="/BillerProvider">
                  Biller Provider
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/BillerProvider">
                  Biller Statement
                </a>
              </li>
            </ul>
            <button className="btn btn-outline-secondary" type="submit">
              Logout
            </button>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default NavBar;
