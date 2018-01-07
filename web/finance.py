from flask import Flask, render_template
from flask import request
from flask import json
import requests

app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('home.html', name='home')

@app.route('/visualize')
def visualize():
    username = request.args.get('username')
    response = requests.get("https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev?username="+username)
    respJSON = response.json()
    income = respJSON["income"]
    rent = respJSON["rent"]
    food = respJSON["food"]
    transportation = respJSON["transportation"]
    recreation = respJSON["recreation"]
    print(transportation)
    # response = requests("https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev?username="+username)
    # string = response.read().decode("utf-8")
    # return render_template('visualize.html', name='visualize', data=json.loads(string))
    return render_template('visualize.html', name='visualize', data={ "income" : income, "rent" : rent, "food" : food, "transportation" : transportation, "recreation" : recreation})
