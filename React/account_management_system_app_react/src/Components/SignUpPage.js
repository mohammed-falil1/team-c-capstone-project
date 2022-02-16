import { React, useEffect, useState } from "react";
import SignUpForm from "./SignUpForm";
import axios from "axios";

function SignUpPage() {
  const [isSubmitted, setIsSubmitted] = useState(false);
  const submitForm = () => {
    setIsSubmitted(true);
  };

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
          <h1>Success. You will receive a mail.</h1>
        </>
      )}
    </div>
  );
}

export default SignUpPage;
