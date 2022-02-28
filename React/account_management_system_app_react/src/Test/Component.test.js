import { shallow } from "enzyme";
import React from "react";
import BillerPay from "../Components/BillerPay";

describe("BillerPay Test", () => {
  it("renders without crashing BillerPay", () => {
    shallow(<BillerPay />);
  });
  //checking a particular tag
  it("renders Biller tag", () => {
    const container = shallow(<BillerPay />);
    const tag = <h3>Biller Pay</h3>;
    expect(container.contains(tag)).toEqual(true);
  });
  it("includes two inputs", () => {
    const container = shallow(<BillerPay />);
    expect(container.find("input").length).toEqual(2);
  });

  it("includes one submit button", () => {
    const container = shallow(<BillerPay />);
    expect(container.find("#submit").length).toEqual(1);
  });
});
