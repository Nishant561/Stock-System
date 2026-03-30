import React, { useState } from "react";
import "../App.css";
import "../index.css";
import { FaKey } from "react-icons/fa6";
import { FaRegEyeSlash } from "react-icons/fa";
import { FaEye } from "react-icons/fa";
import { Link } from "react-router";

function SignupForm() {
  const [show, setShow] = useState(false);
  const [userDetails, setUserDetails] = useState({
    username:'',
    password:'',
    email:''
  });

  const handelSeeButton = () => {
    setShow((show) => !show);
  };

  return (
    <>
      <div className="sign-in-container bg-(--primary-color)/25 rounded-2xl border border-(--primary-color)  w-4/6 flex flex-col items-center  text-(--secondary-color) px-6 py-4">
        <h1 className="text-white text-2xl font-semibold">Sign up</h1>

        <form className="mt-5 flex flex-col w-full gap-6">
            <input
                type="text"
                placeholder="Preferred Name (Optional)"
                value={userDetails.username}
                name="username"
                onChange={(e)=> setUserDetails((val) => ({...val , [e.target.name]:e.target.value}))}
                className="border  border-(--primary-color) rounded-2xl p-3 w-full hover:border-white transition-all duration-150"
            
            
            />


          <input
            type="email"
            placeholder="Email"
            value={userDetails.email}
            name="email"
            onChange={(e)=> setUserDetails((val) => ({...val , [e.target.name]:e.target.value}))}
            className="border  border-(--primary-color) rounded-2xl p-3 w-full hover:border-white transition-all duration-150"
          />

          <div className="relative">
            <input
              type={show ? "text" : "password"}
              placeholder="Password"
              name="password"
              value={userDetails.password}
              onChange={(e)=> setUserDetails((val)=> ({...val , [e.target.name]:e.target.value}))}
              className="border   border-(--primary-color) rounded-2xl p-3 w-full hover:border-white transition-all duration-150"
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
          <div className="-mt-3">
                <p className="font-semibold">Minimum 10 characters.</p>
                <p className="text-xs text-justify mt-3">
                    By signing up, you agree to Nishant's Terms of Use and Privacy Policy. By providing your email, you consent to receive communications from Wealthsimple. You can opt-out anytime.
                </p>
            </div>


          

          <hr className=" border-0 h-[0.1px] bg-(--primary-color) w-full" />

          <div className="flex flex-col w-full items-center gap-5">
            <button
              type="submit"
              className="bg-(--primary-color) px-5 py-2.5 rounded-3xl text-[18px] text-gray-400 w-44  cursor-pointer transition-all duration-150 relative group"
            >
              Next
              {/* <div className=" absolute h-full w-full bg-(--primary-color) opacity-0  top-0 left-0 rounded-3xl  group-hover:opacity-10 pointer-events-none  "></div> */}
            </button>
            

            <p className="text-[14px]">
              Already have a account?{" "}
              <Link to="/login" className="underline text-white">
                Log in Here
              </Link>
            </p>
          </div>
        </form>
      </div>
    </>
  );
}

export default SignupForm;
