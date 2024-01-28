import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Adduser = () => {
  const navigation = useNavigate();
  const [user, setUser] = useState({
    username: "",
    password: "",
    email: "",
  });

  const { username, password, email } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/user", user);
    navigation("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-3 mt-2 shadow">
          <h2 className="text-center m-4">Register User</h2>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              Username
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter your username"
              name="username"
              value={username}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              Password
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter your password"
              name="password"
              value={password}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              E-mail
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter your email"
              name="email"
              value={email}
              onChange={(e) => onInputChange(e)}
            />
            <button
              type="submit"
              className="btn btn-outline-primary mt-2"
              onClick={(e) => onSubmit(e)}
            >
              Submit
            </button>
            <Link className="btn btn-outline-danger mt-2 mx-2" to="/">
              Cancel
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Adduser;
