import LoginFooter from "../components/Login_Components/LoginFooter";
import { Outlet } from "react-router";
import LoginImage from "../components/Login_Components/LoginImage";

function AuthLayout() {
  return (
    <>
      <div className="bg-black text-white h-screen w-full">
        <div className="login-container h-full flex ">
          <LoginImage />

          <div className="login-credentials-container shrink-0 w-3xl  h-full flex-col justify-between  flex items-center pt-24 ">
            <Outlet />
            

            <LoginFooter />
          </div>
        </div>
      </div>
    </>
  );
}

export default AuthLayout;
