import React from "react";
import { useState } from "react";

function BillerRegister() {

  const [values, setValues] = useState({email: '', psw:''});      
    
  const handleChangeEmail = (event) => {
    setValues((values) => ({
      ...values,
      email: event.target.value,
    }));
  };
  const handleChangePassword = (event) => {
    setValues((values) => ({
      ...values,
      psw: event.target.value,
    }));
  };

  const handleSubmit=(event) => {
    // alert(values.email+''+values.psw)
    event.preventDefault();
  }

  return(
    <div>
    <div className="login">
    <form onSubmit={handleSubmit}>
    <h2>Welcome to The Biller Register Page</h2>
    <p>Please Register This Page</p>
    <hr></hr>
    
    <table>
    
    <tr>
      <td><label>Email: </label></td>
      <td><input name="email" type="text" placeholder="enter email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required value={values.email} onChange={handleChangeEmail}/></td>
    </tr>
    <tr>
      <td><label>Password: </label></td>
      <td><input name="psw" type="password" placeholder="enter password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required value={values.psw} onChange={handleChangePassword}/></td>
    </tr>
    <tr>
      <td><label>Remember Me </label></td>
      <td><input name="remember" type="checkbox"/></td>
    </tr>
    </table><br/>
    
    <button type="submit" value="Login" >Login</button>
    </form>
    </div>
    </div>
);
}
export default BillerRegister;
