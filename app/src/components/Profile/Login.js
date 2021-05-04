import React from "react";
import styled from "styled-components/native";
import Icon from "react-native-vector-icons/MaterialIcons";

const LoginContainer = styled.View`
  position: absolute;
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
  background-color: blue;
`;

const IconExitButton = styled.TouchableOpacity``;

const IconExit = styled(Icon)`
  color: white;
`;

const Login = ({ setPopLogin }) => {
  const onPressExit = () => {
    setPopLogin(false);
  };

  return (
    <LoginContainer>
      <IconExitButton onPress={onPressExit}>
        <IconExit name="close" size={40} />
      </IconExitButton>
    </LoginContainer>
  );
};

export default Login;
