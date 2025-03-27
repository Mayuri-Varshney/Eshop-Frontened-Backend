const Header = () => {
  return (
    <div style={{ textAlign: "center", padding: "50px 20px", backgroundColor: "#f8f9fa", borderRadius: "10px" }}>
      <h1 style={{ fontSize: "3rem", color: "#343a40", marginBottom: "20px" }}>Hello, world!</h1>
      <p style={{ fontSize: "1.25rem", color: "#6c757d", marginBottom: "20px" }}>
        Hello User, welcome to EShop—your one-stop solution for all your needs.
      </p>
      <hr style={{ width: "60%", margin: "20px auto", border: "1px solid #dee2e6" }} />
      <p style={{ fontSize: "1rem", color: "#6c757d" }}>
        It uses utility classes for typography and spacing to space content out
        within the larger container.
      </p>
      <a
        href="#"
        style={{
          display: "inline-block",
          padding: "10px 20px",
          fontSize: "1.25rem",
          color: "white",
          backgroundColor: "#007bff",
          textDecoration: "none",
          borderRadius: "5px",
          marginTop: "20px",
        }}
      >
        Start Shopping
      </a>
    </div>
  );
};

export default Header;
