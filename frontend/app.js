import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from './screens/HomeScreen';
import SectorFeedScreen from './screens/SectorFeedScreen';
import AlertScreen from './screens/AlertScreen';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name="SectorFeed" component={SectorFeedScreen} />
        <Stack.Screen name="Alerts" component={AlertScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}