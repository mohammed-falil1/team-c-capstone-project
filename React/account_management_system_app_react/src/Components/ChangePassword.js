import React, { useEffect, useState } from "react";
import NavBar from "./NavBar";

function ChangePassword(props) {
  const initState = { oldPassword: "", newPassword: "", confirmPassword: "" };
  const [values, setValues] = useState(initState);
  const [isSubmitted, setIsSubmitted] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({ ...values, [name]: value });
  };

  const [errors, setErrors] = useState("");
  const headers = {
    "Content-Type": "application/json",
    Authorization: props.token,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  };

  useEffect(() => {
    if (isSubmitted) {
    }
  }, [isSubmitted]);

  const handleSubmit = (e) => {
    if (values.newPassword === values.confirmPassword) {
      setErrors(false);
      setIsSubmitted(true);
    } else {
      console.log("password is incorrect");
      setErrors("Confirm Password is not same");
    }
    e.preventDefault();
  };

  return (
    <>
      <NavBar />
      <div>
        <div class="form-body ">
          <div class="row">
            <div class="form-holder">
              <div class="form-content">
                <div class="form-items">
                  <h3>ChangePassword</h3>
                  <form class="requires-validation" onSubmit={handleSubmit}>
                    <div class="col-md-12">
                      <label
                        for="password"
                        style={{ padding: "9px 0px 0px 9px" }}
                      >
                        Old Password :
                      </label>
                      <input
                        type="password"
                        class="form-control"
                        name="oldPassword"
                        value={values.password}
                        onChange={handleChange}
                        placeholder="Password"
                        id="password"
                        required
                      />
                    </div>
                    <div class="col-md-12">
                      <label
                        for="password"
                        style={{ padding: "9px 0px 0px 9px" }}
                      >
                        New Password :
                      </label>
                      <input
                        type="password"
                        class="form-control"
                        name="newPassword"
                        value={values.password}
                        onChange={handleChange}
                        placeholder="Password"
                        id="password"
                        required
                      />
                    </div>
                    <div class="col-md-12">
                      <label
                        for="password"
                        style={{ padding: "9px 0px 0px 9px" }}
                      >
                        Confirm Password :
                      </label>
                      <input
                        type="password"
                        class="form-control"
                        name="confirmPassword"
                        value={values.password}
                        onChange={handleChange}
                        placeholder="Password"
                        id="password"
                        required
                      />
                    </div>
                    <div id="showError"> {errors && <p>{errors}</p>}</div>

                    <div class="form-button mt-3">
                      <button
                        id="changePasswordBtn"
                        type="submit"
                        class="btn btn-primary"
                        style={{ marginRight: "20px" }}
                      >
                        Change Password
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

export default ChangePassword;
