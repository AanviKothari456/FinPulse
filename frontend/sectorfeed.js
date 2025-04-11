import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet } from 'react-native';
import axios from 'axios';

export default function SectorFeedScreen({ route }) {
  const { sector } = route.params;
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/posts/${sector}`)
      .then(res => setPosts(res.data))
      .catch(err => console.error(err));
  }, [sector]);

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>Posts for {sector}</Text>
      <FlatList
        data={posts}
        keyExtractor={item => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Text>{item.content}</Text>
            <Text style={styles.meta}>Sentiment: {item.sentiment} ({item.confidence})</Text>
          </View>
        )}
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
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  card: {
    backgroundColor: '#f0f0f0',
    padding: 10,
    marginBottom: 10,
    borderRadius: 5,
  },
  meta: {
    color: '#666',
    fontSize: 12,
  },
});
