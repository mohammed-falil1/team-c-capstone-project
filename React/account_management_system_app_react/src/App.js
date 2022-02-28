// import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import React, { useState } from "react";

import { BrowserRouter, Routes, Route} from "react-router-dom";
import BillerRegister from "./Components/BillerRegister";
import DepositOrWithdraw from "./Components/DepositOrWithdraw";

import Transfer from "./Components/Transfer";
import AddPayee from "./Components/AddPayee";
import SignUpPage from "./Components/SignUpPage";
import BillerPay from "./Components/BillerPay";
import BillerStatement from "./Components/BillerStatement";
import AdminApproval from "./Components/AdminApprovalPage";
import LoginPage from "./Components/LoginPage";
import AfterLogin from "./Components/AfterLogin";
import AccountStatements from "./Components/AccountStatements";
import ChangePassword from "./Components/ChangePassword";

function App() {
  const [token, setToken] = useState();
  const [accountNumber, setAccountNumber] = useState();

  return (
    <div className="app">
      <BrowserRouter>
        <Routes>
          <Route
            exact
            path="/"
            element={
              <LoginPage
                setToken={setToken}
                setAccountNumber={setAccountNumber}
              />
            }
          />
          <Route exact path="/signup" element={<SignUpPage />} />
          <Route
            exact
            path="/account"
            element={<AfterLogin accountNumber={accountNumber} />}
          />

          <Route
            exact
            path="/BillerPay"
            element={<BillerPay token={token} accountNumber={accountNumber} />}
          />
          <Route
            exact
            path="/BillerRegister"
            element={
              <BillerRegister token={token} accountNumber={accountNumber} />
            }
          />
          <Route
            exact
            path="/BillerStatement"
            element={
              <BillerStatement token={token} accountNumber={accountNumber} />
            }
          />
          <Route
            exact
            path="/deposit"
            element={
              <DepositOrWithdraw token={token} accountNumber={accountNumber} />
            }
          />

          <Route
            exact
            path="/transfer"
            element={<Transfer token={token} accountNumber={accountNumber} />}
          />
          <Route
            exact
            path="/addPayee"
            element={<AddPayee token={token} accountNumber={accountNumber} />}
          />
          <Route
            exact
            path="/admin-approval"
            element={
              <AdminApproval token={token} accountNumber={accountNumber} />
            }
          />
          <Route
            exact
            path="/acct-stmt"
            element={
              <AccountStatements token={token} accountNumber={accountNumber} />
            }
          />
          <Route
            exact
            path="/change-password"
            element={
              <ChangePassword token={token} accountNumber={accountNumber} />
            }
          />

        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default App;
