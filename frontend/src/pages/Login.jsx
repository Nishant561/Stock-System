import React from "react";
import "../App.css";
import "../index.css";

import LoginForm from "../components/LoginForm";
import LoginFooter from "../components/LoginFooter";
import LoginImage from "../components/LoginImage";

function Login() {
  return (
    <>
      {/* <div className="bg-black text-white h-screen w-full">
        <div className="login-container h-full flex">
          <LoginImage />

          <div className="login-credentials-container w-1/2 h-full flex-col justify-between  flex items-center pt-24">
            <LoginForm />

            <LoginFooter />
          </div>
        </div>
      </div> */}

    <LoginForm/>




    </>
  );
}

export default Login;
