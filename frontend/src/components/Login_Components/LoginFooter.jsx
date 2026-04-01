import React from 'react'
import "../../App.css";

import "../../index.css"
function LoginFooter() {
  return (
    <>
    
        <div className="flex w-full flex-col">
              <hr className="border-0 h-[0.1px] bg-(--primary-color) w-full" />
              <div className="flex  justify-between w-full h-14 px-8 py-1.5 items-center text-sm ">
                <a href="#" className="underline">
                  Help-Center
                </a>

                <div className="flex items-center gap-5 ">
                  <p className="">Download our mobile apps</p>

                  <ul className="flex gap-5 underline">
                    <a href="#">iPhone</a>
                    <a href="#">Android</a>
                  </ul>
                </div>
              </div>
            </div>
    </>
  )
}

export default LoginFooter