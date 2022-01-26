// import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import React from "react";

import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import BillerRegister from "./Components/BillerRegister";
import BillerProvider from "./Components/BillerProvider";
import LinkPages from "./Components/LinkPages";
import About from "./Components/About";
import NavBar from "./Components/NavBar";
import Home from "./Components/Home";
import Sample from "./Components/Sample";
import SignUp from "./Components/SignUp";

function App() {
  return (
    <div className="app">
      {/* <BillerRegister /> */}
      {/* <Home title="Home"  userText="User" /> */}

      <BrowserRouter>
        <NavBar />
        <Routes>
          {/* <Route path="/NavBar" element={NavBar} /> */}
          <Route exact path="/" element={<SignUp />} />
          <Route exact path="/Home" element={<Home />} />
          <Route exact path="/BillerProvider" element={<BillerProvider />} />
          <Route exact path="/BillerRegister" element={<BillerRegister />} />
          <Route exact path="/About" element={<About />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default App;
