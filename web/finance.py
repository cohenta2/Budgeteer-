from flask import Flask, render_template
from flask import request
from flask import json

app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('home.html', name='home')

@app.route('/visualize')
def visualize():
    # username = request.args.get('username')
    # response = requests("https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev?username="+username)
    # string = response.read().decode("utf-8")
    # return render_template('visualize.html', name='visualize', data=json.loads(string))
    return render_template('visualize.html', name='visualize')
