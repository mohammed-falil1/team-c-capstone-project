import React from "react";
import { Link } from "react-router-dom";

const LinkPages = () => {
  return (
    <header class="header">
      <div class="left">
        <a href="/">Welcome</a>
      </div>

      <div class="mid">
        <ul class="navbar">
          <li>
            <Link to="/home">Home</Link>
          </li>
          <li>
            <Link to="/billerregister">Biller Register</Link>
          </li>
          <li>
            <Link to="/billerprovider">Biller Provider</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
        </ul>
      </div>

      <div class="right">
        <a href="/">Sign out</a>
      </div>
    </header>
  );
};
export default LinkPages;
