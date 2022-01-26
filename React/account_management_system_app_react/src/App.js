// import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import React from "react";

import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import BillerRegister from "./Components/BillerRegister";
import BillerProvider from "./Components/BillerProvider";
import About from "./Components/About";
import NavBar from "./Components/NavBar";
import Home from "./Components/Home";
import SignUp from "./Components/SignUp";
import Deposit from "./Components/Deposit";
import Withdraw from "./Components/Withdraw";
import Transfer from "./Components/Transfer";
import AddPayee from "./Components/AddPayee";

function App() {
  return (
    <div className="app">
      <BrowserRouter>
        <NavBar />
        <Routes>
          {/* <Route path="/NavBar" element={NavBar} /> */}
          <Route exact path="/" element={<SignUp />} />
          <Route exact path="/Home" element={<Home />} />
          <Route exact path="/BillerProvider" element={<BillerProvider />} />
          <Route exact path="/BillerRegister" element={<BillerRegister />} />

          <Route exact path="/deposit" element={<Deposit />} />
          <Route exact path="/withdraw" element={<Withdraw />} />
          <Route exact path="/transfer" element={<Transfer />} />
          <Route exact path="/addPayee" element={<AddPayee />} />

          <Route exact path="/About" element={<About />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default App;
