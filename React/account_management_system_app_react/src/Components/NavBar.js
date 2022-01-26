import { React, useState } from "react";
import "../CSS/NavBar.css";

const handler = () => {
 
};

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
              <li className="nav-item" >
                <a className="nav-link" href="/">
                  Home
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

              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="/"
                  id="navbarDropdown"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                ></a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li>
                    <a className="dropdown-item" href="/">
                      Airtel
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="/">
                      Jio
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="/">
                      SpectraNet
                    </a>
                  </li>
                  <li>
                    <hr className="dropdown-divider" />
                  </li>
                  <li>
                    <a className="dropdown-item" href="/">
                      Idea
                    </a>
                  </li>
                </ul>
              </li>

              <li className="nav-item">
                <a className="nav-link" href="/About">
                  About
                </a>
              </li>

              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="/"
                  id="navbarDropdown"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                ></a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li>
                    <a className="dropdown-item" href="/">
                      Contact Us
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="/">
                      Mail Us
                    </a>
                  </li>
                </ul>
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
