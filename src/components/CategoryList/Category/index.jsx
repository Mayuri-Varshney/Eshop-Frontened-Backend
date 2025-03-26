import { useState } from "react";
import { Link } from "react-router-dom";

const Category = (props) => {
  const { id, name, image } = props.data;
  return (
    <div style={{ width: "25%", padding: "10px" }}>
      <div style={{ border: "1px solid #ddd", borderRadius: "8px", overflow: "hidden", boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)" }}>
        <img src={image} alt={name} style={{ width: "100%", height: "200px", objectFit: "cover" }} />
        <div style={{ padding: "15px" }}>
          <h5 style={{ margin: "0 0 10px", fontSize: "1.25rem" }}>{name}</h5>
          <Link to="/products" style={{ display: "block", padding: "10px 15px", textAlign: "center", backgroundColor: "#007bff", color: "white", textDecoration: "none", borderRadius: "5px" }}>
            Select
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Category;
