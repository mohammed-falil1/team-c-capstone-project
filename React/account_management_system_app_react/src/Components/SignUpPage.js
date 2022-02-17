import { React, useEffect, useState } from "react";
import SignUpForm from "./SignUpForm";

import { useNavigate } from "react-router-dom";

function SignUpPage() {
  const [isSubmitted, setIsSubmitted] = useState(false);
  const submitForm = () => {
    setIsSubmitted(true);
  };

  const navigate = useNavigate();

  useEffect(() => {
    if (isSubmitted) {
    }
  }, [isSubmitted]);

  return (
    <div>
      {!isSubmitted ? (
        <SignUpForm submitForm={submitForm} />
      ) : (
        <>
          {/* <h1>Success. You will receive a mail.</h1> */}
          {alert("User Registered Successfully")}
          {navigate("/")}
        </>
      )}
    </div>
  );
}

export default SignUpPage;
