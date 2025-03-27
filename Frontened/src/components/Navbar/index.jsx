import { Link, useNavigate } from "react-router-dom";
import React, { useState, useEffect } from "react";

const Navbar = () => {
  const navigate = useNavigate();
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    let token = localStorage.getItem("token");
    if (!token) {
      setIsLoggedIn(false);
    } else {
      setIsLoggedIn(true);
    }
  }, []);

  const onLogoutHandler = () => {
    localStorage.clear();
    setIsLoggedIn(false);
    navigate("/login");
  };

  return (
    <nav style={{ backgroundColor: "#343a40", padding: "10px 20px", display: "flex", justifyContent: "space-between", alignItems: "center" }}>
      <Link style={{ color: "white", textDecoration: "none", fontSize: "24px", fontWeight: "bold" }} to="/">
        EShop
      </Link>

      <div style={{ display: "flex", gap: "20px" }}>
        <Link style={{ color: "white", textDecoration: "none", fontSize: "18px" }} to="/">
          Home
        </Link>
        <Link style={{ color: "white", textDecoration: "none", fontSize: "18px" }} to="/about">
          About
        </Link>
        <Link style={{ color: "white", textDecoration: "none", fontSize: "18px" }} to="/products">
          Product
        </Link>
        <Link style={{ color: "white", textDecoration: "none", fontSize: "18px" }} to="/contact">
          Contact
        </Link>
      </div>

      <div>
        {!isLoggedIn ? (
          <Link style={{ padding: "8px 16px", backgroundColor: "#007bff", color: "white", textDecoration: "none", borderRadius: "5px" }} to="/login">
            Login
          </Link>
        ) : (
          <button
            style={{ padding: "8px 16px", backgroundColor: "#dc3545", color: "white", border: "none", borderRadius: "5px", cursor: "pointer" }}
            onClick={onLogoutHandler}
          >
            Logout
          </button>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
