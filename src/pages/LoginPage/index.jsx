import React, { useState } from "react";
import axios from "axios";
import { Formik, Form, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";

const LoginPage = () => {
  const navigate = useNavigate();

  const [requstResponse, setRequestRespose] = useState({
    message: "",
    alertClassName: "",
  });

  const initialValues = {
    email: "",
    password: "",
  };

  const onSubmit = (values) => {
    values = {
      ...values,
      usernameOrEmail: values.email,
    };
    axios
      .post("http://localhost:8080/api/auth/login", values)
      .then((response) => {
        setRequestRespose({
          message: "User login successfully",
          alertClassName: "success",
        });
        localStorage.setItem("token", response.data);
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
        setRequestRespose({
          message: "Invalid email or password",
          alertClassName: "error",
        });
      });
  };

  const validationSchema = Yup.object({
    email: Yup.string()
      .required("Please enter email")
      .email("Please enter a valid email"),
    password: Yup.string()
      .required("Please enter password")
      .min(6, "Password must be at least 6 characters"),
  });

  return (
    <div style={{ maxWidth: "600px", height: "700px", margin: "0 auto", padding: "40px" }}>
      <div style={{ display: "flex", justifyContent: "center" }}>
        <div style={{ width: "100%" }}>
          {requstResponse.message && (
            <div
              style={{
                padding: "10px",
                borderRadius: "5px",
                marginBottom: "20px",
                fontSize: "18px",
                color: requstResponse.alertClassName === "success" ? "green" : "red",
              }}
            >
              {requstResponse.message}
            </div>
          )}
          <h2 style={{ textAlign: "center", fontSize: "28px" }}>Login</h2>
          <hr />
          <Formik
            initialValues={initialValues}
            onSubmit={onSubmit}
            validationSchema={validationSchema}
            validateOnMount
          >
            {(formik) => (
              <Form onSubmit={formik.handleSubmit}>
                <div style={{ marginBottom: "20px" }}>
                  <label style={{ fontSize: "18px" }}>Email</label>
                  <Field
                    type="text"
                    name="email"
                    style={{
                      display: "block",
                      width: "100%",
                      padding: "12px",
                      borderRadius: "5px",
                      fontSize: "16px",
                      border: formik.errors.email && formik.touched.email ? "1px solid red" : "1px solid #ccc",
                    }}
                  />
                  <ErrorMessage name="email" component="small" style={{ color: "red" }} />
                </div>

                <div style={{ marginBottom: "20px" }}>
                  <label style={{ fontSize: "18px" }}>Password</label>
                  <Field
                    type="password"
                    name="password"
                    style={{
                      display: "block",
                      width: "100%",
                      padding: "12px",
                      borderRadius: "5px",
                      fontSize: "16px",
                      border: formik.errors.password && formik.touched.password ? "1px solid red" : "1px solid #ccc",
                    }}
                  />
                  <ErrorMessage name="password" component="small" style={{ color: "red" }} />
                </div>

                <button
                  type="submit"
                  disabled={!formik.isValid}
                  style={{
                    width: "100%",
                    padding: "12px",
                    backgroundColor: "#007bff",
                    color: "white",
                    border: "none",
                    borderRadius: "5px",
                    fontSize: "18px",
                    cursor: formik.isValid ? "pointer" : "not-allowed",
                  }}
                >
                  Login
                </button>
              </Form>
            )}
          </Formik>
          <br />
          <p style={{ textAlign: "center", fontSize: "18px" }}>
            New User? <a href="/">Click Here</a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;