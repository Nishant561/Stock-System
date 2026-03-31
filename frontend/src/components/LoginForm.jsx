import React, { useState } from "react";
import "../App.css";
import "../index.css";
import { FaKey } from "react-icons/fa6";
import { FaRegEyeSlash } from "react-icons/fa";
import { FaEye } from "react-icons/fa";
import { Link } from "react-router";
import Input from "./Input";

function LoginForm() {
  const [show, setShow] = useState(false);

  const[userDetails, setUserDetails] = useState({
    email:"",
    password:""
  })

  const handelChange = (e)=>{
    setUserDetails((val)=> ({...val , [e.target.name]:e.target.value}))
  }

  const handelSeeButton = () => {
    setShow((show) => !show);
  };

  return (
    <>
      <div className="sign-in-container bg-(--primary-color)/25 rounded-2xl border border-(--primary-color)  w-4/6 flex flex-col items-center  text-(--secondary-color) px-6 py-4">
        <h1 className="text-white text-2xl font-semibold">Welcome Back</h1>

        <form className="mt-5 flex flex-col w-full gap-6">
          
          <Input
            type={"email"}
            placeholder={"Email"}
            value={userDetails.email}
            name={"email"}
            handelChange={handelChange}
          />

          <div className="relative">
           

            <Input
              type={"password"}
              placeholder={"Password"}
              value={userDetails.password}
              name={"password"}
              handelChange={handelChange}
            
            />

            <div
              className="absolute right-5 top-1/2 -translate-y-1/2 hover:bg-(--primary-color)/50 p-2 rounded-full group"
              onClick={handelSeeButton}
            >
              {show ? (
                <FaEye className="text-[16px] cursor-pointer" />
              ) : (
                <FaRegEyeSlash className="text-[16px] cursor-pointer" />
              )}

              <span className="absolute -bottom-8 left-1/2 -translate-x-1/2 bg-white text-(--primary-color) text-xs px-2 py-1 rounded whitespace-nowrap opacity-0 group-hover:opacity-100 transition-opacity">
                {show ? "Hide Password" : "Show Password"}
              </span>
            </div>
          </div>

          <a
            href="/"
            className="underline text-white w-fit hover:bg-(--primary-color)/20"
          >
            Forgot-Password?
          </a>

          <hr className=" border-0 h-[0.1px] bg-(--primary-color) w-full" />

          <div className="flex flex-col w-full items-center gap-5">
            <button
              type="submit"
              className="bg-white px-5 py-2.5 rounded-3xl text-[18px] text-(--primary-color) w-44  cursor-pointer transition-all duration-150 relative group"
            >
              Log in
              <div className=" absolute h-full w-full bg-(--primary-color) opacity-0  top-0 left-0 rounded-3xl  group-hover:opacity-10 pointer-events-none  "></div>
            </button>
            <a
              href="/"
              className="border px-5 py-2.5 rounded-3xl text-[16px] text-white hover:bg-(--primary-color)/20 font-semibold transition-all duration-150 flex items-center gap-1"
            >
              Log in with a passKey
              <FaKey />
            </a>

            <p className="text-[14px]">
              Don't have an account?{" "}
              <Link to="/signup" className="underline text-white">
                Sign up
              </Link>
            </p>
          </div>
        </form>
      </div>
    </>
  );
}

export default LoginForm;
