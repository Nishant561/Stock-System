import React from 'react'

function Input({type="text", placeholder, value, name, handelChange }) {
  return (
    <>

        <input
                type={type}
                placeholder={placeholder}
                value={value}
                name={name}
                onChange={handelChange}
                className="border  border-(--primary-color) focus:bg-transparent rounded-2xl p-3 w-full hover:border-white transition-all duration-150"
            
            />

    
    </>
  )
}

export default Input