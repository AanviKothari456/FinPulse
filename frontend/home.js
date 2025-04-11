import React, { useState, useEffect } from 'react';
import { View, Text, Button, FlatList, StyleSheet } from 'react-native';
import axios from 'axios';

export default function HomeScreen({ navigation }) {
  const [sectors, setSectors] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/sectors')
      .then(res => setSectors(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>Track a Sector</Text>
      <FlatList
        data={sectors}
        keyExtractor={item => item.id.toString()}
        renderItem={({ item }) => (
          <Button
            title={item.name}
            onPress={() => navigation.navigate('SectorFeed', { sector: item.name })}
          />
        )}
      />
      <Button
        title="View Alerts"
        onPress={() => navigation.navigate('Alerts')}
        color="#cc0000"
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 20,
    marginTop: 50,
  },
  heading: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 20,
  },
});