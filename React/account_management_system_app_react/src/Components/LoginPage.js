import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginPage(props) {
  const initState = { userName: "", password: "" };
  const [values, setValues] = useState(initState);
  const [submit, isSubmit] = useState(false);
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    isSubmit(true);
    e.preventDefault();
  };

  useEffect(() => {
    if (submit === true) {
      const sendEmailAndPassUrl = "http://localhost:8080/auth/login";
      console.log(values);
      axios.post(sendEmailAndPassUrl, values).then((response) => {
        console.log(response);
        if (response.data.authenticated) {
          console.log("from login page ", response.data.accountNumber);
          props.setAccountNumber(response.data.accountNumber);
          props.setToken("Bearer " + response.data.token);
          navigate("/deposit");
        } else {
          alert("Invalid UserName and Password");
          window.location.reload();
        }

        console.log(response);
      });
    }
  }, [submit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({ ...values, [name]: value });
    console.log(e.target.value);
  };

  const handleSignup = () => {
    navigate("/signUp");
  };

  const handleAdminLogin = () => {
    let adminLoginURL = "http://localhost:8080/auth/admin-login";
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    if (email.length > 0 && password.length > 0) {
      let adminLogin = {
        userName: email,
        password: password,
      };
      axios.post(adminLoginURL, adminLogin).then((response) => {
        console.log(response.data);
        if (response.data === true) {
          navigate("/admin-approval");
        } else {
          alert("Invalid Username or Password");
        }
      });
    }
  };

  return (
    <>
      <div>
        <div class="form-body ">
          <div class="row">
            <div class="form-holder">
              <div class="form-content">
                <div class="form-items">
                  <h3>Login</h3>
                  <form class="requires-validation" onSubmit={handleSubmit}>
                    <div class="col-md-12">
                      <label for="email" style={{ padding: "9px 0px 0px 9px" }}>
                        Email
                      </label>
                      <input
                        type="text"
                        class="form-control"
                        name="userName"
                        value={values.email}
                        onChange={handleChange}
                        placeholder="Email"
                        id="email"
                        required
                      />
                    </div>

                    <div class="col-md-12">
                      <label
                        for="password"
                        style={{ padding: "9px 0px 0px 9px" }}
                      >
                        Enter Password :
                      </label>
                      <input
                        type="password"
                        class="form-control"
                        name="password"
                        value={values.password}
                        onChange={handleChange}
                        placeholder="Password"
                        id="password"
                        required
                      />
                    </div>

                    <div class="form-button mt-3">
                      <button
                        id="submit"
                        type="submit"
                        class="btn btn-primary"
                        style={{ marginRight: "20px" }}
                      >
                        User Login
                      </button>
                      <button
                        id="submit"
                        type="button"
                        class="btn btn-primary"
                        onClick={handleAdminLogin}
                        style={{ marginRight: "20px" }}
                      >
                        Admin Login
                      </button>
                      <button
                        id="submit"
                        type="submit"
                        class="btn btn-primary"
                        onClick={handleSignup}
                      >
                        Signup
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default LoginPage;
