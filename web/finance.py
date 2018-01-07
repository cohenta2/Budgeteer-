from flask import Flask, render_template
from flask import request

app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('home.html', name='home')

@app.route('/visualize')
def visualize():
    username = request.args.get('username')
    data = {'username' :  request.args.get('username')}
    return render_template('visualize.html', name='visualize', data={'username' :  request.args.get('username')})
