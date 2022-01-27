import { React } from "react";
import axios from "axios";
import "../CSS/SignUp.css";

function SignUp() {
  const baseURL = "http://localhost:8080/visit/new-account";

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

  const formSubmit = (event) => {
    event.preventDefault();

    var title = document.getElementById("mySelect").value;
    var fullName = document.getElementById("fullName").value;
    var dob = document.getElementById("dob").value;
    var email = document.getElementById("email").value;
    var mobileNumber = document.getElementById("mobileNumber").value;
    var panCard = document.getElementById("panCard").value;
    var aadhar = document.getElementById("aadhar").value;
    var initialBalance = document.getElementById("initialBalance").value;
    console.log(
      "printing values :" +
        title +
        fullName +
        dob +
        email +
        mobileNumber +
        panCard +
        aadhar +
        initialBalance
    );

    console.log("inside form submit");
    axios
      .post(baseURL, {
        title: title,
        fullName: fullName,
        dob: dob,
        email: email,
        mobileNumber: mobileNumber,
        panCard: panCard,
        aadhar: aadhar,
        uploadAddress: "somethingAddress",
        initialBalance: initialBalance,
      })
      .then(() => {
        alert("User Successfully registered ");
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
                <form class="requires-validation" onSubmit={formSubmit}>
                  <div class="col-md-12 mt-3">
                    <label
                      for="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Title :
                    </label>
                    <select
                      // value={this.state.selectValue}
                      id="mySelect"
                    >
                      <option value="Mr">Mr</option>
                      <option value="Ms">Ms</option>
                      <option value="Mrs">Mrs</option>
                    </select>
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
                      name="fullName"
                      id="fullName"
                      placeholder="Full Name"
                      defaultValue=""
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
                      name="dob"
                      id="dob"
                      defaultValue=""
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
                      id="email"
                      placeholder="E-mail Address"
                      defaultValue=""
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
                      name="mobileNumber"
                      placeholder="Mobile Number"
                      defaultValue=""
                      id="mobileNumber"
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
                      name="panCard"
                      placeholder="Pan Card Number"
                      defaultValue=""
                      id="panCard"
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
                      name="aadhar"
                      id="aadhar"
                      placeholder="Aadhar Card Number"
                      defaultValue=""
                      required
                    />
                  </div>

                  <div class="col-md-12">
                    <label
                      for="initialBalance"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Initial Balance
                    </label>
                    <input
                      type="number"
                      class="form-control"
                      name="initialBalance"
                      required
                      id="initialBalance"
                      defaultValue=""
                    />

                    <div class="invalid-feedback">
                      Example invalid form file feedback
                    </div>
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
                      id="aadhar-file"
                      defaultValue=""
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
                      defaultValue=""
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
                      defaultValue=""
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
