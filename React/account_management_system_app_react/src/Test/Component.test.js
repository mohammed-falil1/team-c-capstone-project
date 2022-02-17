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

///state test
// it("should update state on click", () => {
//     const changeSize = jest.fn();
//     const wrapper = shallow(<BillerStatement />);
//     const handleClick = jest.spyOn(React, "useState");
//     handleClick.mockImplementation(size => [size, changeSize]);

//     wrapper.find("#submit").simulate("click");
//     expect(changeSize).toBeCalled();

//   });

// it("Test click event", () => {
//   const mockCallBack = jest.fn();
//   const container = shallow(<BillerPay handleSubmit={mockCallBack} />);
//   container.find("#submit").simulate("click");
//   expect(mockCallBack.mock.calls.length).toEqual(1);
//   expect(mockCallBack).toHaveBeenCalled();
// });

///axios
// it("test axios get",()=>{
//   axios.get.mockImplementation(() => Promise.resolve({ data: {...} }));

// })
