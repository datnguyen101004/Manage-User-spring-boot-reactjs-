import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

const Home = () => {
  const [users, setUsers] = useState([]);
  const { id } = useParams();

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/users");
    setUsers(result.data);
  };
  useEffect(() => {
    loadUsers();
  }, []);

  const handleDelete = async (id) => {
    const result = await axios.delete(`http://localhost:8080/delete/${id}`);
    loadUsers();
  };

  return (
    <div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">STT</th>
            <th scope="col">USERNAME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">PASSWORD</th>
            <th scope="col">ACTION</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user, index) => (
            <tr>
              <th scope="row" key={index}>
                {index + 1}
              </th>
              <td>{user.username}</td>
              <td>{user.email}</td>
              <td>{user.password}</td>
              <td>
                <button className="btn btn-outline-primary mx-2">View</button>
                <Link
                  className="btn btn-primary mx-2"
                  to={`/edit-user/${user.id}`}
                >
                  Edit
                </Link>
                <button
                  className="btn btn-danger mx-2"
                  onClick={() => handleDelete(user.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Home;
