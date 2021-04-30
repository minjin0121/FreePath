import React from "react";
import styled from "styled-components/native";
import { SafeAreaView } from "react-native-safe-area-context";
import { ScrollView } from "react-native";
import Icon from "react-native-vector-icons/MaterialIcons";
import Carousel from "../assets/images/carousel_0.jpg";
import Card from "../components/Home/Card";
import MenuButton from "../components/Common/MenuButton";

const HomeContainer = styled.View`
  display: flex;
  align-items: center;
  background-color: white;
  height: 100%;
`;

// 캐러셀 컴포넌트 분리 예정

const CarouselContainer = styled.View`
  width: 100%;
  height: 200px;
`;

const CarouselImage = styled.Image`
  position: absolute;
  width: 100%;
  height: 100%;
`;

const CarouselTextBox = styled.View`
  display: flex;
  justify-content: flex-end;
  height: 100%;
  padding-left: 20px;
  padding-bottom: 40px;
  background-color: rgba(0, 0, 0, 0.3);
`;

const CarouselText = styled.Text`
  color: white;
  font-size: 18px;
  font-weight: bold;
`;

// 보드 컴포넌트 분리 예정

const BoardContainer = styled.View`
  display: flex;
  width: 100%;
  height: 1000px;
  background-color: white;
  padding-left: 10px;
  padding-right: 10px;
`;

const BoardLabelBox = styled.View`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-end;
  width: 100%;
  padding-right: 10px;
  padding-left: 10px;
  margin-top: 20px;
`;

const BoardLabelTagText = styled.Text`
  color: black;
  font-size: 15px;
  font-weight: bold;
`;

const BoardLabelSetupText = styled.Text`
  color: #d41d1d;
  font-size: 15px;
  font-weight: bold;
`;

// 카드 컴포넌트 분리 예정

const CardContainer = styled.View`
  margin-top: 15px;
  width: 100%;
  height: 80px;
  border-radius: 10px;
  background-color: #f9f1f7;
  display: flex;
  justify-content: center;
  align-items: center;
  elevation: 3;
`;

const Home = ({ setPopMenu }) => (
  <SafeAreaView>
    <ScrollView>
      <HomeContainer>
        <MenuButton setPopMenu={setPopMenu} />
        <CarouselContainer>
          <CarouselImage source={Carousel} />
          <CarouselTextBox>
            <CarouselText>늦은 밤,</CarouselText>
            <CarouselText>당신의 귀가를</CarouselText>
            <CarouselText>책임지겠습니다.</CarouselText>
          </CarouselTextBox>
        </CarouselContainer>
        <BoardContainer>
          <BoardLabelBox>
            <BoardLabelTagText>내 알림</BoardLabelTagText>
            <BoardLabelSetupText>알림 관리</BoardLabelSetupText>
          </BoardLabelBox>
          <Card
            title="멀티캠퍼스 역삼"
            address="서울특별시 강남구 역삼동 테헤란로 212"
            time="10:30 AM"
          />
          <CardContainer>
            <Icon name="add-circle" size={40} color="rgba(0, 0, 0, 0.3)" />
          </CardContainer>
        </BoardContainer>
      </HomeContainer>
    </ScrollView>
  </SafeAreaView>
);

export default Home;
