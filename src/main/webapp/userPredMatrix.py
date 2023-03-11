
import csv
import os
from math import sqrt
import sys
import pyodbc
import numpy as np
import pandas as pd
from sklearn.metrics.pairwise import pairwise_distances


def load_music_data():
    conn = pyodbc.connect('Driver={SQL Server};'
                          'Server=ANHQUAN;'
                          'Database=22MUSIC;'
                          'Trusted_Connection=yes;')
    cursor = conn.cursor()
    cursor.execute('SELECT Song_Id, User_Id, Rating FROM History')
    idx  =0
    for i in cursor:
        df = pd.DataFrame(data=[[i[0],i[1],i[2]]], columns=['song_id', 'user_id', 'rating'])
        if(idx==0):
            # h1 = np.array([i[0],i[1],i[2]])
            df1 = df
        else:
            df1=df1.append(df,ignore_index=True)
        idx+=1
    return df1

# def write_data(file_name):
#     if os.path.exists(file_name):
#         print("-- " + file_name + " found locally")
#         df = pd.t

def values_to_map_index(values):
    map_index = {}
    idx = 0
    for val in values:
        map_index[val] = idx
        idx += 1

    return map_index




def predict(ratings, similarity):


    pred = similarity.dot(ratings) / np.array(
        [np.abs(similarity).sum(axis=1)]).T

    return pred





if __name__ == "__main__":
    
    fileuser = sys.argv[1]
    filesong = sys.argv[2]

    # Load music data
    song_data = load_music_data()
    # song_data.to_csv('D:/Web/TestJava/test2/src/test3.txt')

    # Reduce complexity by getting first n elements


    user_idx = values_to_map_index(song_data.user_id.unique())
    # print(user_idx)
    song_idx = values_to_map_index(song_data.song_id.unique())


    # print(song_data)


    n_users = song_data.user_id.unique().shape[0]
    n_items = song_data.song_id.unique().shape[0]
    print("Number of users = " + str(n_users) + " | Number of songs = " + str(n_items))


    train_data_matrix = np.zeros((n_users, n_items)) + 0.5

    for line in song_data.itertuples():
        train_data_matrix[user_idx[line[2]], song_idx[line[1]]] = line[3]



    user_similarity = 1 - pairwise_distances(train_data_matrix, metric='cosine')
    item_similarity = 1 - pairwise_distances(train_data_matrix.T, metric='cosine')


    user_prediction = predict(train_data_matrix, user_similarity)
    # print(train_data_matrix)
    # print (user_similarity)
    # print(user_prediction)
    # print(item_similarity)
    # print(user_similarity[0,:])
    ab = 0
   
    b = np.argsort(user_prediction)
    a = np.argsort(item_similarity)
    # print(user_idx)
    # print(song_idx)
    # print(user_prediction)
    # print(b)
    # print(np.flip(b, 1))

with open(filesong, 'w') as f:
    writer = csv.writer(f)
    writer.writerow(range(0, n_items))
    writer.writerows(np.flip(a, 1))
# with open('D:/Web/TestJava/test2/src/test2.txt') as f:
#     print(f.read())
with open(fileuser,'w') as f:
    writer = csv.writer(f)
    writer.writerow(range(0, n_items))
    writer.writerows(np.flip(b, 1))









