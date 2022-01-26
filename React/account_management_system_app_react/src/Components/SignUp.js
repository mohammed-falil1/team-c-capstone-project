import { React, useEffect, useState } from "react";
import axios from "axios";
import "../CSS/SignUp.css";

function SignUp() {
  const baseURL = "http://localhost:9000/visit/new-account";

  const calculateAge = (dob) => {
    var today = new Date();
    var birthDate = new Date(dob);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    return age;
  };

  const formSubmit = () => {
    axios
      .post(baseURL, {
        title: "MR",
        fullName: "Mohammed Falil",
        dob: "17/07/1999",
        email: "z-gonim0@developermail.com",
        mobileNumber: 8680980924,
        panCard: "ABCD43526",
        aadhar: 1234567890,
        uploadAddress: "somethingAddress",
        initialBalance: 1000,
      })
      .then((response) => {
        console.log(response.data);
      });
  };

  return (
    <div>
      <div class="form-body">
        <div class="row">
          <div class="form-holder">
            <div class="form-content">
              <div class="form-items">
                <h3>Register Today</h3>
                <p>Fill in the data below.</p>
                <form
                  class="requires-validation"
                  novalidate
                  onSubmit={formSubmit()}
                >
                  <div class="col-md-12 mt-3">
                    <label
                      class="mb-3 mr-1"
                      for="gender"
                      style={{ marginRight: "10px" }}
                    >
                      Title:{" "}
                    </label>

                    <input
                      type="radio"
                      class="btn-check"
                      name="gender"
                      id="male"
                      autocomplete="off"
                      required
                    />
                    <label
                      class="btn btn-sm btn-outline-secondary"
                      for="male"
                      style={{ marginRight: "10px" }}
                    >
                      Mr
                    </label>

                    <input
                      type="radio"
                      class="btn-check"
                      name="gender"
                      id="female"
                      autocomplete="off"
                      required
                    />
                    <label
                      class="btn btn-sm btn-outline-secondary"
                      for="female"
                      style={{ marginRight: "10px" }}
                    >
                      Ms
                    </label>

                    <input
                      type="radio"
                      class="btn-check"
                      name="gender"
                      id="secret"
                      autocomplete="off"
                      required
                    />
                    <label
                      class="btn btn-sm btn-outline-secondary"
                      for="secret"
                    >
                      Ms
                    </label>
                    <div class="valid-feedback mv-up">
                      You selected a gender!
                    </div>
                    <div class="invalid-feedback mv-up">
                      Please select a gender!
                    </div>
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Full Name :
                    </label>
                    <input
                      class="form-control"
                      type="text"
                      name="name"
                      placeholder="Full Name"
                      required
                    />
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      D.O.B :
                    </label>
                    <input
                      class="form-control"
                      type="date"
                      name="date"
                      required
                    />
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Email :
                    </label>
                    <input
                      class="form-control"
                      type="email"
                      name="email"
                      placeholder="E-mail Address"
                      required
                    />
                  </div>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Mobile Number :
                    </label>
                    <input
                      class="form-control"
                      type="number"
                      name="number"
                      placeholder="Mobile Number"
                      required
                    />
                  </div>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Pan Card Number :
                    </label>
                    <input
                      class="form-control"
                      type="text"
                      name="text"
                      placeholder="Pan Card Number"
                      required
                    />
                  </div>
                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Aadhar Card Number :
                    </label>
                    <input
                      class="form-control"
                      type="text"
                      name="text"
                      placeholder="Aadhar Card Number"
                      required
                    />
                  </div>
                  <div class="col-md-12">
                    <label for="aadhar" style={{ padding: "9px 0px 0px 9px" }}>
                      Aadhar.pdf
                    </label>
                    <input
                      type="file"
                      class="form-control"
                      name="aadhar-file"
                      required
                      id="aadhar"
                    />

                    <div class="invalid-feedback">
                      Example invalid form file feedback
                    </div>
                  </div>

                  <div class="col-md-12">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Pan Card.pdf
                    </label>
                    <input
                      type="file"
                      class="form-control"
                      name="pan-card-file"
                      required
                      id="pan-card"
                    />

                    <div class="invalid-feedback">
                      Example invalid form file feedback
                    </div>
                  </div>

                  <div
                    class="form-check"
                    style={{ paddingTop: "9px", marginLeft: "10px" }}
                  >
                    <input
                      class="form-check-input"
                      type="checkbox"
                      value=""
                      id="invalidCheck"
                      required
                    />
                    <label class="form-check-label">
                      I confirm that all data are correct
                    </label>
                    <div class="invalid-feedback">
                      Please confirm that the entered data are all correct!
                    </div>
                  </div>

                  <div class="form-button mt-3">
                    <button id="submit" type="submit" class="btn btn-primary">
                      Register
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SignUp;
