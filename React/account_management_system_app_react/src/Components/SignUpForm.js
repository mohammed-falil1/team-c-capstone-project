import React from "react";
import useForm from "../CustomHooks/useForm";
import Validate from "./Validate";
import "../CSS/SignUpForm.css";

function SignUpForm({ submitForm }) {
  const {
    handleChange,
    handleSubmit,
    values,
    errors,
    handleFileSelected,
    handleCheckBox,
  } = useForm({ submitForm, Validate });

  return (
    <div>
      <div className="form-body">
        <div className="row">
          <div className="form-holder">
            <div className="form-content">
              <div className="form-items">
                <h3>Register Today</h3>
                <p>Fill in the data below.</p>
                <form
                  className="requires-validation"
                  onSubmit={handleSubmit}
                  noValidate
                >
                  <div className="col-md-12 mt-3">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Title :
                    </label>
                    <select
                      id="title"
                      name="title"
                      value={values.title}
                      onChange={handleChange}
                    >
                      <option value="Mr">Mr</option>
                      <option value="Ms">Ms</option>
                      <option value="Mrs">Mrs</option>
                    </select>
                  </div>

                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Full Name :
                    </label>
                    <input
                      className="form-control"
                      type="text"
                      name="fullName"
                      id="fullName"
                      placeholder="Full Name"
                      value={values.fullName}
                      onChange={handleChange}
                      required
                    />
                    <div id="showError">
                      {" "}
                      {errors.fullName && <p>{errors.fullName}</p>}
                    </div>
                  </div>

                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      D.O.B :
                    </label>
                    <input
                      className="form-control"
                      type="date"
                      name="dob"
                      id="dob"
                      value={values.dob}
                      onChange={handleChange}
                      required
                    />
                    <div id="showError">
                      {" "}
                      {errors.dob && <p>{errors.dob}</p>}
                    </div>
                  </div>

                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Email :
                    </label>
                    <input
                      className="form-control"
                      type="email"
                      name="email"
                      id="email"
                      placeholder="E-mail Address"
                      value={values.email}
                      onChange={handleChange}
                      required
                    />
                    <div id="showError">
                      {" "}
                      {errors.email && <p>{errors.email}</p>}
                    </div>
                  </div>
                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Mobile Number :
                    </label>
                    <input
                      className="form-control"
                      type="number"
                      name="mobileNumber"
                      placeholder="Mobile Number"
                      value={values.mobileNumber}
                      onChange={handleChange}
                      id="mobileNumber"
                      required
                    />
                    <div id="showError">
                      {" "}
                      {errors.mobileNumber && <p>{errors.mobileNumber}</p>}
                    </div>
                  </div>
                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Pan Card Number :
                    </label>
                    <input
                      className="form-control"
                      type="text"
                      name="panCard"
                      placeholder="Pan Card Number"
                      value={values.panCard}
                      onChange={handleChange}
                      id="panCard"
                      required
                    />
                    <div id="showError">
                      {" "}
                      {errors.panCard && <p>{errors.panCard}</p>}
                    </div>
                  </div>
                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Aadhar Card Number :
                    </label>
                    <input
                      className="form-control"
                      type="text"
                      name="aadhar"
                      id="aadhar"
                      placeholder="Aadhar Card Number"
                      value={values.aadhar}
                      onChange={handleChange}
                      required
                    />
                    <div id="showError">
                      {" "}
                      {errors.aadhar && <p>{errors.aadhar}</p>}
                    </div>
                  </div>

                  <div className="col-md-12">
                    <label
                      htmlFor="initialBalance"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Initial Balance
                    </label>
                    <input
                      type="number"
                      className="form-control"
                      name="initialBalance"
                      required
                      id="initialBalance"
                      value={values.initialBalance}
                      onChange={handleChange}
                    />
                    <div id="showError">
                      {" "}
                      {errors.initialBalance && <p>{errors.initialBalance}</p>}
                    </div>
                  </div>

                  <div className="col-md-12">
                    <label
                      htmlFor="aadhar"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Aadhar.pdf
                    </label>
                    <input
                      type="file"
                      className="form-control"
                      name="aadhar-file"
                      required
                      id="aadhar-file"
                      value={values.aadharFile}
                      // defaultValue=""
                      onChange={handleFileSelected}
                    />

                    <div id="showError">
                      {" "}
                      {errors.aadharFile && <p>{errors.aadharFile}</p>}
                    </div>
                  </div>

                  <div className="col-md-12">
                    <label
                      htmlFor="pan-card"
                      style={{ padding: "9px 0px 0px 9px" }}
                    >
                      Pan Card.pdf
                    </label>
                    <input
                      type="file"
                      className="form-control"
                      name="pan-card-file"
                      required
                      id="pan-card"
                      value={values.panCardFile}
                      // defaultValue=""
                      onChange={handleFileSelected}
                    />
                    <div id="showError">
                      {" "}
                      {errors.panCardFile && <p>{errors.panCardFile}</p>}
                    </div>
                  </div>

                  <div
                    className="form-check"
                    style={{ paddingTop: "9px", marginLeft: "10px" }}
                  >
                    <input
                      className="form-check-input"
                      type="checkbox"
                      value=""
                      id="invalidCheck"
                      onChange={handleCheckBox}
                      required
                    />
                    <label className="form-check-label">
                      I confirm that all data are correct
                    </label>
                    <div style={{}}> {errors.isChecked && <p>{errors.isChecked}</p>}</div>
                  </div>

                  <div className="form-button mt-3">
                    <button
                      id="submit"
                      type="submit"
                      className="btn btn-primary"
                    >
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

export default SignUpForm;
