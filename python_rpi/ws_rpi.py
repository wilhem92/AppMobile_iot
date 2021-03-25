#!flask/bin/python
from flask import Flask
from gpiozero import LED
from time import sleep

led1=LED(2)
led2=LED(3)
led3=LED(14)

app = Flask(__name__)

@app.route('/')
def index():
    return "Hello, World!"

@app.route('/action/')
@app.route('/action/<id>/<command>')
def action(id='1',command='off'):
    status="{'status':0}"
    if command=='on':
        if id=='1' :
            led1.off()
            status="{'status':1}"
            print(" Lampe 1 ON")
        if id=='2' :
            led2.off()
            status="{'status':1}"
            print(" Lampe 2 ON")
        if id=='3' :
            led3.off()
            status="{'status':1}"
            print(" Lampe 3 ON")
    if command=='off':
        if id=='1' :
            led1.on()
            status="{'status':1}"
            print(" Lampe 1 OFF")
        if id=='2' :
            led2.on()
            status="{'status':1}"
            print(" Lampe 2 OFF")
        if id=='3' :
            led3.on()
            status="{'status':1}"
            print(" Lampe 3 OFF")
    return status

if __name__ == '__main__':
    app.run(host='192.168.0.189',debug=True)