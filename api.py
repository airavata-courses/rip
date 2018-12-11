from flask import *
import json

app = Flask(__name__)


@app.route("/getFiles", methods=['GET', 'POST'])
def hello():
    if request.method == 'GET':
        return json.dumps(["file1.csv", "file2.csv", "file3.csv", "file4.csv"])
    else:
        raw = request.json()
        return "okay"


@app.route("/selectedFiles", methods=['GET', 'POST'])
def hello1():
    raw = request.json()
    return "okay"


if __name__ == "_main_":
    app.run()
