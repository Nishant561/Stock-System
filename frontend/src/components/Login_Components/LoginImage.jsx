import React from 'react'
import "../../App.css";

import "../../index.css"
function LoginImage() {
  return (
    <>
        <div className="login-image-container w-1/2 h-full p-5 relative">
            <a href="/" className="font-bold text-(--primary-color) text-3xl">
              Nishant.Dev
            </a>

            <div className="login-image-text-container absolute top-1/2 left-1/2   -translate-x-1/2 -translate-y-1/2 w-8/12 text-(--primary-color)">
              <div className="flex flex-col items-center gap-8">
                <p className="text-3xl text-center">The (Un)Real Deal</p>
                <h1 className="text-5xl font-bold w-full text-center">
                  Get up to a 3% match. Win a $3M home.
                </h1>

                <p className="text-xl text-center">
                  <a href="/" className="underline">
                    Register
                  </a>{" "}
                  and start an eligible account transfer to qualify for your
                  match — and get 5,000 entries to win the home.
                  <a href="/" className="underline">
                    T&Cs
                  </a>
                  apply.
                </p>
              </div>
            </div>
          </div>
    
    </>
  )
}

export default LoginImage