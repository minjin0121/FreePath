import React, { useEffect } from "react";
import styled from "styled-components/native";

const ProfileView = styled.View`
  display: flex;
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: center;
  background-color: white;
`;

const Profile = ({ setPopLogin, isLoggedIn }) => {
  useEffect(() => {
    if (!isLoggedIn) {
      setPopLogin(true);
    }
  }, []);

  if (!isLoggedIn) {
    return <ProfileView />;
  }

  return <ProfileView />;
};

export default Profile;
